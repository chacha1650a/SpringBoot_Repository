package com.korit.todoapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoReq {
    private Long userId;
    private Long categoryId;
    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    private String memo;
    private LocalDateTime dueDate;
    private LocalDateTime dueTime;
    private LocalDateTime createdAt;
    private String priority;
    private int isCompleted;
}
