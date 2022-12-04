package com.example.moneysecureauthflux.exception.handling;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiErrorMessages {
    //
    public static final String BAD_REQUEST = "Invalid request. Please check request once more. ";
    public static final String NOT_FOUND = "Could not find requesting data. ";
    public static final String INTERNAL_SERVER_ERROR = "Error occurs while exchange data with database. Please try again later, after checking given error details. ";
    public static final String UNSUPPORTED_MEDIA_TYPE = "Error occurs cause coming unsupported media type. Please send shown body only. ";
    public static final String METHOD_NOT_ALLOWED = "Used not valid http method. Please check it. ";
    public static final String ERROR_WHILE_CALLING_TKB = "Error Occurred while calling TKB API ";
    public static final String ACCESS_DENIED = "This resource is forbidden for this credentials! ";
    public static final String UNAUTHORIZED = "Please login first in order to access the resource! ";
    public static final String ERROR_WHILE_CALLING_CBU = "Error Occurred while calling CBU API ";
    public static final String ERROR_WHILE_CALLING_IsAPI = "Error Occurred while calling IS API ";
    public static final String ERROR_WHILE_CALLING_INPS = "Error Occurred while calling INPS API ";
    public static final String ERROR_WHILE_CALLING_NIBBD = "Error Occurred while calling NIBBD API ";
    public static final String REDIS_ERROR = "Error Occured while exchange data with redis! ";
    public static final String ERROR_CALLING_EBP = "Error Occurred while calling EBP api";
    public static final String ERROR_CALLING_NSI = "Error Occurred while calling NSI api";
    public static final String STOP_CLIENT = "Client is occurred in Stop List !";
}

