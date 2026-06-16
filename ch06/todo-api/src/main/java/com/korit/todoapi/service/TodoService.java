package com.korit.todoapi.service;


import com.korit.todoapi.dto.CreateResponse;
import com.korit.todoapi.dto.todo.TodoCompletionReq;
import com.korit.todoapi.dto.todo.TodoModifyReq;
import com.korit.todoapi.dto.todo.TodoReq;
import com.korit.todoapi.dto.todo.TodoResp;
import com.korit.todoapi.entity.Todo;
import com.korit.todoapi.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper todoMapper;

    public CreateResponse create(TodoReq dto) {
        Todo todo = dto.toTodo();
        todoMapper.insert(todo);
        return CreateResponse.builder()
                .domainName("todo")
                .createdIds(List.of(todo.getId()))
                .build();
    }

    public List<TodoResp> getAll(Long userId) {
        return todoMapper.selectAll()
                .stream()
                .map(Todo::toResponse)
                .toList();
    }

    public void complete(TodoCompletionReq dto) {
        todoMapper.updateCompleted(dto.getTodoId(), dto.isCompleted());
    }

    public void modify(TodoModifyReq dto) {
        todoMapper.update(dto.toTodo());
    }

    public void delete(Long todoId) {
        todoMapper.delete(todoId);
    }
}
