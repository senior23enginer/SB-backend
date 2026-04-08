package com.mayoristas.interfaz_contable.auth.custom_user_details.domain;

import java.io.Serial;

public class CustomUserDetailsNotFound extends  RuntimeException {

    @Serial
    private static final long serialVersionUID = -6480052076175713548L;
    private static final String NOT_FOUND = "Username not found";

    public CustomUserDetailsNotFound(String message) {
        super(NOT_FOUND +": "+message);
    }
}
