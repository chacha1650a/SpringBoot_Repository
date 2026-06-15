package com.korit.todoapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryReq {
    @NotBlank(message = "카테고리 이름은 필수입니다.")
    private String name;
    private String color;
    private String icon;
}
