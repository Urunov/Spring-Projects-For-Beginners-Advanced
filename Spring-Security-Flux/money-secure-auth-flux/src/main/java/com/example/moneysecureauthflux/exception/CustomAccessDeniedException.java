package com.example.moneysecureauthflux.exception;


import com.example.moneysecureauthflux.domain.ResultsDto;
import com.example.moneysecureauthflux.exception.handling.ApiErrorMessages;
import com.google.gson.Gson;
import io.vavr.collection.Seq;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpStatus.FORBIDDEN;

public class CustomAccessDeniedException extends DomainExceptionWithErrors implements ServerAccessDeniedHandler {

    public CustomAccessDeniedException(String reason) {
        this(reason, null, null);
    }

    public CustomAccessDeniedException(String objectName, String reason) {
        this(reason, null, null);
    }

    public CustomAccessDeniedException(String reason, String objectName,
                                       Seq<DomainError> errors) {
        super(FORBIDDEN, reason, objectName, errors);
    }

    /**
     * CUstom Handler for Access Denied Exception
     *
     * @param serverWebExchange ServerWebExchange
     * @param e                 AccessDeniedException
     * @return Mono<Void>
     */
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, AccessDeniedException e) {

        ResultsDto resultsDto = new ResultsDto(ApiErrorMessages.ACCESS_DENIED, 403);
        byte[] bytes = new Gson().toJson(resultsDto).getBytes(StandardCharsets.UTF_8);

        ServerHttpResponse response = serverWebExchange.getResponse();
        DataBuffer buffer = response.bufferFactory().wrap(bytes);
        response.setStatusCode(FORBIDDEN);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeWith(Mono.just(buffer));

    }
}
