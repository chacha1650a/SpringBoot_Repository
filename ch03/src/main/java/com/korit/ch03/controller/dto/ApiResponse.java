package com.korit.ch03.controller.dto;

import lombok.Builder;
import lombok.Data;

// 모든 요청에 대한 공통 응답 (static으로 생성)
@Data
@Builder
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T body;

    public static <T> ApiResponse<T> ok() {
        return ApiResponse.<T>builder()
                .success(true)
                .message("요청 성공했습니다.")
                .build();
    }

    public static <T> ApiResponse<T> ok(T body) {
        return ApiResponse.<T>builder()
                .success(true)
                .message("요청 성공했습니다.")
                .body(body)
                .build();
    }

    public static <T> ApiResponse<T> fail() {
        return ApiResponse.<T>builder()
                .success(false)
                .message("요청 실패했습니다.")
                .build();
    }

    public static <T> ApiResponse<T> fail(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .build();
    }

    public static <T> ApiResponse<T> fail(T body) {
        return ApiResponse.<T>builder()
                .success(false)
                .message("요청 실패했습니다.")
                .body(body)
                .build();
    }

    public static <T> ApiResponse<T> fail(String message, T body) {
        return ApiResponse.<T>builder()
                .success(false)
                .message("요청 실패했습니다.")
                .body(body)
                .build();
    }
}
