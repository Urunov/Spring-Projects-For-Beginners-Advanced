package com.example.moneysecureauthflux.auth.route;

import com.example.moneysecureauthflux.auth.handler.AuthHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class AuthRouter {

    @Bean
    @SuppressWarnings("NullableProblems")
    public RouterFunction<ServerResponse> authRoute(AuthHandler authHandler) {
        return RouterFunctions.route(
                        POST("/login").and(accept(MediaType.APPLICATION_JSON)), authHandler::login)
                .andRoute(POST("/sign-up").and(accept(MediaType.APPLICATION_JSON)), authHandler::signUp)
                .andRoute(POST("/block/{id}").and(accept(MediaType.APPLICATION_JSON)), authHandler::blockUser)
                .andRoute(POST("/unblock/{id}").and(accept(MediaType.APPLICATION_JSON)), authHandler::unblockUser)
                .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)), authHandler::getAllUsers)
                .andRoute(PUT("/users/{id}").and(accept(MediaType.APPLICATION_JSON)).and(contentType(MediaType.APPLICATION_JSON)), authHandler::updateUser);
    }
}
