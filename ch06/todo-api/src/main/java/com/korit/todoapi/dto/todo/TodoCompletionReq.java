package com.korit.todoapi.dto.todo;

import lombok.Data;

@Data
public class TodoCompletionReq {
    private Long todoId;
    private Long userId;
    private boolean isCompleted;
}
