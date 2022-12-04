package com.example.moneysecureauthflux.domain;

import java.io.Serializable;

public class ResultsDto implements Serializable {

    private static final long serialVersionUID = -8457257838264102466L;

    private String message;
    private Integer code;

    public ResultsDto(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
