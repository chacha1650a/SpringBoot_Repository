package com.korit.ch03.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class DuplicatedException extends RuntimeException {
    private String fieldName;
    private Object value;

    public DuplicatedException(String message, String fieldName, Object value) {
        super(message);
        this.fieldName = fieldName;
        this.value = value;
    }
}
