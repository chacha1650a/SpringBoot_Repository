package com.korit.ch04api.dto;

import com.korit.ch04api.entity.Todo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TodoResponse {
    private int todoId;
    private int userId;
    private String title;
    private String content;
    private boolean done;
    private LocalDateTime createdAt;

    public static TodoResponse fromEntity(Todo todo) {
        return TodoResponse.builder()
                .todoId(todo.getTodoId())
                .userId(todo.getUserId())
                .title(todo.getTitle())
                .content(todo.getContent())
                .done(todo.isDone())
                .createdAt(todo.getCreatedAt())
                .build();
    }
}
