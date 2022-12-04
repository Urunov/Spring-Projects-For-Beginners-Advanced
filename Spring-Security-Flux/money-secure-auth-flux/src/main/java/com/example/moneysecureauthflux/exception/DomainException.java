package com.example.moneysecureauthflux.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ToString(callSuper = true)
public class DomainException extends ResponseStatusException {
    DomainException(HttpStatus status, String reason) {
        super(status, reason);
    }

}
