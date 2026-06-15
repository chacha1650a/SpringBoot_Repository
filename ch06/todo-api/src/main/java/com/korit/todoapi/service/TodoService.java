package com.korit.todoapi.service;


import com.korit.todoapi.dto.*;
import com.korit.todoapi.entity.Todo;
import com.korit.todoapi.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper todoMapper;

    public TodoResp createTodo(TodoReq req) {
        Todo todo = Todo.builder()
                .userId(req.getUserId())
                .categoryId(req.getCategoryId())
                .title(req.getTitle())
                .memo(req.getMemo())
                .dueDate(req.getDueDate())
                .dueTime(req.getDueTime())
                .priority(req.getPriority())
                .isCompleted(req.getIsCompleted())
                .build();

        todoMapper.insert(todo);
        return TodoResp.fromEntity(todo);
    }

    public List<TodoResp> selectById() {
        return todoMapper.selectById().stream()
                .map(TodoResp::fromEntity)
                .collect(Collectors.toList());
    }
}
