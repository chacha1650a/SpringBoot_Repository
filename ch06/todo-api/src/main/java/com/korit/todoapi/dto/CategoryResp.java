package com.korit.todoapi.dto;

import com.korit.todoapi.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResp {
    private Long id;
    private Long userId;
    private String name;
    private String color;
    private String icon;

    public static CategoryResp fromEntity(Category category) {
        return CategoryResp.builder()
                .id(category.getId())
                .userId(category.getUserId())
                .name(category.getName())
                .color(category.getColor())
                .icon(category.getIcon())
                .build();
    }
}
