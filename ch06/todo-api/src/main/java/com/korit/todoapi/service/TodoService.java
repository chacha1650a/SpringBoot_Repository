package com.korit.todoapi.service;


import com.korit.todoapi.dto.*;
import com.korit.todoapi.entity.Todo;
import com.korit.todoapi.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<TodoResp> selectByUserId() {
        return todoMapper.selectByUserId().stream()
                .map(TodoResp::fromEntity)
                .collect(Collectors.toList());
    }

    public TodoResp updateTodo(Long id, TodoReq req) {

        Todo todo = todoMapper.selectById(id);
        if (todo == null) {
            throw new IllegalArgumentException("해당 값이 존재하지 않습니다. id=" + id);
        }

        // 2. 요청값으로 데이터를 변경합니다.
        todo.setTitle(req.getTitle());
        todo.setMemo(req.getMemo());
        todo.setDueDate(req.getDueDate());
        todo.setDueTime(req.getDueTime());
        todo.setIsCompleted(req.getIsCompleted());
        todo.setPriority(req.getPriority());

        todoMapper.updateTodo(todo);
        return TodoResp.fromEntity(todo);
    }

    public TodoResp patchTodo(Long userId, Long id, ToggleReq req) {
        Todo todo = todoMapper.selectById(id);
        if (todo == null) {
            throw new IllegalArgumentException("해당 값이 존재하지 않습니다. id=" + id);
        }

        if (!todo.getUserId().equals(userId)) {
            throw new SecurityException("해당 값을 수정할 권한이 없습니다.");
        }

        if (req.getIsCompleted() != null) {
            todo.setIsCompleted(req.getIsCompleted());
        } else {
            int currentState = todo.getIsCompleted();
            todo.setIsCompleted(currentState == 0 ? 1 : 0);
        }

        if (todo.getIsCompleted() == 1) {
            todo.setCompletedAt(java.time.LocalDateTime.now());
        } else {
            todo.setCompletedAt(null);
        }

        todoMapper.updateTodo(todo);
        return TodoResp.fromEntity(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = todoMapper.selectById(id);
        if (todo == null) {
            throw new IllegalArgumentException("해당 값이 존재하지 않습니다. id =" + id);
        }

        todoMapper.deleteTodo(id);
    }
}
