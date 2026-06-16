package com.korit.todoapi.dto.category;

import com.korit.todoapi.entity.CategoryCompletionCount;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class categoryCompletionCountResp {
    private Long id;
    private int totalCount;
    private int notCompletedCount;

    public static categoryCompletionCountResp fromEntity(CategoryCompletionCount completionCount) {
        return categoryCompletionCountResp.builder()
                .id(completionCount.getId())
                .totalCount(completionCount.getTotalCount())
                .notCompletedCount(completionCount.getNotCompletedCount())
                .build();
    }
}

