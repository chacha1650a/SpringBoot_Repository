package com.korit.todoapi.entity;

import com.korit.todoapi.dto.category.CategoryResp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    private Long userId;
    private String name;
    private String color;
    private String icon;
    private LocalDateTime createdAt;

    public CategoryResp toResponse() {
        return CategoryResp.builder()
                .id(id)
                .name(name)
                .color(color)
                .icon(icon)
                .build();
    }
}
