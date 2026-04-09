package com.mayoristas.interfaz_contable.shared.infrastructure.controller.dto;

public record ApiResponse<T>(
        boolean success,
        String message,
        String errorCode,
        T data
) {

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, null, data);
    }

    public static <T> ApiResponse<T> error(String message, String errorCode) {
        return new ApiResponse<>(false, message, errorCode, null);
    }
}
