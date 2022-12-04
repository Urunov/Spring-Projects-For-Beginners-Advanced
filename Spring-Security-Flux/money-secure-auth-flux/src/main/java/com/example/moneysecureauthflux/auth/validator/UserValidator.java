package com.example.moneysecureauthflux.auth.validator;

import com.example.moneysecureauthflux.domain.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "username", "username.empty", "Username is required");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty", "Password is required");
    }
}
