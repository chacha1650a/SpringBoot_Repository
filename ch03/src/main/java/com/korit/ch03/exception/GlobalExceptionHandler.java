package com.korit.ch03.exception;

import com.korit.ch03.controller.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Bean에서만 에외 처리 가능
    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity<ApiResponse> duplicated(DuplicatedException e) {
        String message = "중복된 값입니다.";
        return ResponseEntity.badRequest().body(ApiResponse.fail(message, e));
    }
}
