package com.korit.todoapi.dto.todo;

import com.korit.todoapi.entity.Todo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class TodoResp {
    private Long todoId;
    private Long id;
    private Long userId;
    private Long categoryId;
    private String title;
    private String memo;
    private LocalDate dueDate;
    private LocalTime dueTime;
    private int priority;
    private boolean isFlagged;
    private boolean isCompleted;
    private LocalDateTime completedAt;

    public static TodoResp fromEntity(Todo todo) {
        return TodoResp.builder()
                .id(todo.getId())
                .userId(todo.getUserId())
                .categoryId(todo.getCategoryId())
                .title(todo.getTitle())
                .memo(todo.getMemo())
                .dueDate(todo.getDueDate())
                .dueTime(todo.getDueTime())
                .priority(todo.getPriority())
                .build();
    }
}
