package com.example.moneysecureauthflux.auth.jwt;

import com.example.moneysecureauthflux.domain.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {

    private String a_t;
    private String description;
    private Integer status;
    private Users users;

    public AuthResponse(Integer status, String description) {
        this.status = status;
        this.description = description;
    }

    public AuthResponse(String a_t, Integer status, String description, Users users) {
        this.a_t = a_t;
        this.status = status;
        this.description = description;
        this.users = users;
    }
}
