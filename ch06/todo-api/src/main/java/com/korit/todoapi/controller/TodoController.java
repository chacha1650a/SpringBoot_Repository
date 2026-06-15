package com.korit.todoapi.controller;

import com.korit.todoapi.dto.TodoReq;
import com.korit.todoapi.dto.TodoResp;
import com.korit.todoapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/todos")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResp> createTodo(@RequestBody TodoReq req) {
        return ResponseEntity.ok(todoService.createTodo(req));
    }

    @GetMapping
    public ResponseEntity<List<TodoResp>> selectById() {
        return ResponseEntity.ok(todoService.selectById());
    }
}
