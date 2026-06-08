package com.korit.ch04api.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class TodoRequest {
    @NotBlank(message = "Title is required")
    private String title;
    
    private String content;
}
