package com.example.moneysecureauthflux.auth.handler;

import com.example.moneysecureauthflux.auth.encode.PassEncoder;
import com.example.moneysecureauthflux.auth.jwt.AuthRequest;
import com.example.moneysecureauthflux.auth.jwt.AuthResponse;
import com.example.moneysecureauthflux.auth.jwt.JwtUtil;
import com.example.moneysecureauthflux.domain.Users;
import com.example.moneysecureauthflux.service.UsersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class AuthHandler {
    //
    private final Validator validator;
    private final UsersService userService;
    private final PassEncoder passEncoder;
    private final JwtUtil jwtUtil;

    public AuthHandler(@Qualifier("usersValidator") Validator validator, UsersService userService, UsersService usersService, PassEncoder passEncoder, JwtUtil jwtUtil) {
        this.validator = validator;
        this.userService = usersService;
        this.passEncoder = passEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest) {
        return userService
                .getAllUsers()
                .collectList()
                .flatMap(r -> ServerResponse.ok().bodyValue(r).onErrorResume(Mono::error));
    }

    public Mono<ServerResponse> login(ServerRequest request) {
        Mono<AuthRequest> loginRequest = request.bodyToMono(AuthRequest.class);
        return loginRequest.flatMap(
                login ->
                        userService
                                .getByUsername(login.getUsername())
                                .flatMap(
                                        user -> {
                                            if (passEncoder.matches(login.getPassword(), user.getPassword()) && (Boolean.TRUE.equals(user.getIs_enabled()))) {
                                                user.setPassword(null);
                                                return ServerResponse.ok()
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .body(
                                                                BodyInserters.fromValue(
                                                                        new AuthResponse(jwtUtil.generateToken(user), 200, "Authenticated!", user)));
                                            } else {
                                                return ServerResponse.badRequest()
                                                        .body(
                                                                BodyInserters.fromValue(
                                                                        new AuthResponse(400, "Invalid credentials")));
                                            }
                                        })
                                .switchIfEmpty(
                                        ServerResponse.badRequest()
                                                .body(
                                                        BodyInserters.fromValue(
                                                                new AuthResponse(400, "User does not exist")))));
    }

    public Mono<ServerResponse> signUp(ServerRequest request) {
        Mono<Users> userMono = request.bodyToMono(Users.class).doOnNext(this::validate);
        return userMono
                .map(
                        user -> {
                            user.setPassword(passEncoder.encode(user.getPassword()));
                            return user;
                        })
                .flatMap(
                        user ->
                                userService
                                        .getByUsername(user.getUsername())
                                        .flatMap(
                                                dbUser ->
                                                        ServerResponse.badRequest()
                                                                .body(
                                                                        BodyInserters.fromValue(
                                                                                new AuthResponse(400, "User already exist"))))
                                        .switchIfEmpty(
                                                userService
                                                        .createUser(user)
                                                        .map(savedUser -> {
                                                            savedUser.setPassword(null);
                                                            return savedUser;
                                                        })
                                                        .flatMap(
                                                                savedUser -> ServerResponse.ok()
                                                                        .contentType(MediaType.APPLICATION_JSON)
                                                                        .body(BodyInserters.fromValue(savedUser))
                                                                        .onErrorResume(Mono::error))));
    }

    public Mono<ServerResponse> blockUser(ServerRequest serverRequest) {

        AtomicReference<Long> userId = new AtomicReference<>(0L);

        final String tempId = serverRequest.pathVariable("id");

        if (tempId.length() == 0 || tempId.equals("0"))
            throw new BadRequestException("Id is not given!");

        try {
            userId.set(Long.parseLong(tempId));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Id is not proper format!");
        }

        return serverRequest
                .bodyToMono(Users.class)
                .flatMap(u -> userService.blockUser(u, userId.get()))
                .flatMap(r -> ServerResponse.ok()
                        .bodyValue(r).onErrorResume(Mono::error));
    }

    public Mono<ServerResponse> unblockUser(ServerRequest serverRequest) {

        AtomicReference<Long> userId = new AtomicReference<>(0L);

        final String tempId = serverRequest.pathVariable("id");

        if (tempId.length() == 0 || tempId.equals("0"))
            throw new BadRequestException("Id is not given!");

        try {
            userId.set(Long.parseLong(tempId));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Id is not proper format!");
        }

        return serverRequest
                .bodyToMono(Users.class)
                .flatMap(u -> userService.unblockUser(u, userId.get()))
                .flatMap(r -> ServerResponse.ok()
                        .bodyValue(r).onErrorResume(Mono::error));
    }

    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {

        AtomicReference<Long> userId = new AtomicReference<>(0L);

        final String tempId = serverRequest.pathVariable("id");

        if (tempId.length() == 0 || tempId.equals("0"))
            throw new BadRequestException("Id is not given!");

        try {
            userId.set(Long.parseLong(tempId));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Id is not proper format!");
        }

        return serverRequest
                .bodyToMono(Users.class)
                .flatMap(u -> userService.updateUser(u, userId.get()))
                .flatMap(r -> ServerResponse.ok()
                        .bodyValue(r).onErrorResume(Mono::error));
    }

    private void validate(Users users) {
        Errors errors = new BeanPropertyBindingResult(users, "users");
        validator.validate(users, errors);
        if (errors.hasErrors()) {
            throw new ServerWebInputException(errors.toString());
        }
    }
}
