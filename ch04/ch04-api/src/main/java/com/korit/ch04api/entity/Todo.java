package com.korit.ch04api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int todoId;
    private int userId;
    private String title;
    private String content;
    private boolean done;
    private LocalDateTime createdAt;
}
