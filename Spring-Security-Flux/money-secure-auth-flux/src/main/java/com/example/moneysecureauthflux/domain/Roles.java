package com.example.moneysecureauthflux.domain;

public enum Roles {
    //
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private String roleValue;

    Roles(String roleValue){
        this.roleValue = roleValue;
    }

    public String getRoleValue(){
        return roleValue;
    }


}
