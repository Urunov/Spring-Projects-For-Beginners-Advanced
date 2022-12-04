package com.example.moneysecureauthflux.auth.config;

import com.example.moneysecureauthflux.exception.CustomAccessDeniedException;
import com.example.moneysecureauthflux.exception.CustomUnauthorizedException;
import com.example.moneysecureauthflux.exception.handling.ApiErrorMessages;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
    //
    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository;

    public SecurityConfig(
            AuthenticationManager authenticationManager,
            SecurityContextRepository securityContextRepository) {
        this.authenticationManager = authenticationManager;
        this.securityContextRepository = securityContextRepository;
    }


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){
        return httpSecurity.exceptionHandling()
                .authenticationEntryPoint(
                        new CustomUnauthorizedException(ApiErrorMessages.UNAUTHORIZED)
                )
                .accessDeniedHandler(
                        new CustomAccessDeniedException(ApiErrorMessages.ACCESS_DENIED)
                )
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository)
                .authorizeExchange()
                .pathMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .pathMatchers("/login", "/sign-up", "/testt" )
                .permitAll()
                .pathMatchers("/money-oper/confirm")
                .hasAnyRole("ADMIN")
                .anyExchange()
                .authenticated()
                .and()
                .build();
    }
}
