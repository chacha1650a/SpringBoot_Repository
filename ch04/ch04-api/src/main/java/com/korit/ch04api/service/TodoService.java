package com.korit.ch04api.service;

import com.korit.ch04api.dto.TodoRequest;
import com.korit.ch04api.dto.TodoResponse;
import com.korit.ch04api.entity.Todo;
import com.korit.ch04api.mapper.TodoMapper;
import com.korit.ch04api.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper todoMapper;

    private int getAuthenticatedUserId() {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principalUser.getUser().getId();
    }

    @Transactional(rollbackFor = Exception.class)
    public TodoResponse createTodo(TodoRequest request) {
        int userId = getAuthenticatedUserId();

        Todo todo = Todo.builder()
                .userId(userId)
                .title(request.getTitle())
                .content(request.getContent())
                .done(false)
                .build();

        todoMapper.insertTodo(todo);
        return TodoResponse.fromEntity(todo);
    }

    public List<TodoResponse> getTodos() {
        int userId = getAuthenticatedUserId();
        List<Todo> todos = todoMapper.selectTodosByUserId(userId);
        return todos.stream().map(TodoResponse::fromEntity).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void toggleTodoDone(int todoId) {
        Todo todo = todoMapper.selectTodoById(todoId);
        if (todo != null && todo.getUserId() == getAuthenticatedUserId()) {
            todoMapper.updateTodoStatus(todoId, !todo.isDone());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteTodo(int todoId) {
        Todo todo = todoMapper.selectTodoById(todoId);
        if (todo != null && todo.getUserId() == getAuthenticatedUserId()) {
            todoMapper.deleteTodo(todoId);
        }
    }
}
