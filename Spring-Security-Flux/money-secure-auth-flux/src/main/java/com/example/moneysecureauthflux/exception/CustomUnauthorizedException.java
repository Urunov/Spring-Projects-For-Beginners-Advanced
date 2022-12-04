package com.example.moneysecureauthflux.exception;

import com.example.moneysecureauthflux.domain.ResultsDto;
import com.example.moneysecureauthflux.exception.handling.ApiErrorMessages;
import com.google.gson.Gson;
import io.vavr.collection.Seq;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class CustomUnauthorizedException extends DomainExceptionWithErrors implements ServerAuthenticationEntryPoint {

    public CustomUnauthorizedException(String reason) {
        this(reason, null, null);
    }

    public CustomUnauthorizedException(String objectName, String reason) {
        this(reason, null, null);
    }

    public CustomUnauthorizedException(String reason, String objectName,
                                       Seq<DomainError> errors) {
        super(UNAUTHORIZED, reason, objectName, errors);
    }

    /**
     * CUstom Handler for Unauthorized exception with custom error message
     *
     * @param serverWebExchange ServerWebExchange
     * @param e                 AccessDeniedException
     * @return Mono<Void>
     */
    @Override
    public Mono<Void> commence(ServerWebExchange serverWebExchange, AuthenticationException e) {
        ResultsDto resultsDto = new ResultsDto(ApiErrorMessages.UNAUTHORIZED, 401);
        byte[] bytes = new Gson().toJson(resultsDto).getBytes(StandardCharsets.UTF_8);

        ServerHttpResponse response = serverWebExchange.getResponse();
        DataBuffer buffer = response.bufferFactory().wrap(bytes);
        response.setStatusCode(UNAUTHORIZED);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeWith(Mono.just(buffer));
    }
}
