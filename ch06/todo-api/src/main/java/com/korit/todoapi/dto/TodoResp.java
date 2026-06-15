package com.korit.todoapi.dto;

import com.korit.todoapi.entity.Todo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TodoResp {
    private Long id;
    private Long userId;
    private Long categoryId;
    private String title;
    private String memo;
    private LocalDateTime dueDate;
    private LocalDateTime dueTime;
    private int isCompleted;
    private String priority;

    public static TodoResp fromEntity(Todo todo) {
        return TodoResp.builder()
                .id(todo.getId())
                .userId(todo.getUserId())
                .categoryId(todo.getCategoryId())
                .title(todo.getTitle())
                .memo(todo.getMemo())
                .dueDate(todo.getDueDate())
                .dueTime(todo.getDueTime())
                .isCompleted(todo.getIsCompleted())
                .priority(todo.getPriority())
                .build();
    }
}
