package com.korit.todoapi.entity;

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
    private Long id;
    private Long userId;
    private Long categoryId;
    private String title;
    private String memo;
    private LocalDateTime dueDate;
    private LocalDateTime dueTime;
    private String priority;
    private int isFlagged;
    private int isCompleted;
    private LocalDateTime completedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
