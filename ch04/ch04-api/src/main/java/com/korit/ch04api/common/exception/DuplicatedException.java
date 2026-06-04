package com.korit.ch04api.common.exception;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;

@Getter
@JsonIncludeProperties({"cause", "localizedMessage", "stackTrace", "suppressed"})
public class DuplicatedException extends RuntimeException{
    private String fieldName;
    private Object fieldValue;

    public DuplicatedException(String message, String fieldName, Object fieldValue) {
        super(message);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
