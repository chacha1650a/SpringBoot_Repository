package com.korit.todoapi.controller;

import com.korit.todoapi.dto.TodoReq;
import com.korit.todoapi.dto.TodoResp;
import com.korit.todoapi.dto.ToggleReq;
import com.korit.todoapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public ResponseEntity<List<TodoResp>> selectByUserId() {
        return ResponseEntity.ok(todoService.selectByUserId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResp> updateTodo(@PathVariable Long id, @RequestBody TodoReq req) {
        return ResponseEntity.ok(todoService.updateTodo(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoResp> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoResp> patchTodo(@AuthenticationPrincipal Long userId, @PathVariable Long id, @RequestBody ToggleReq req) {
        return ResponseEntity.ok(todoService.patchTodo(userId, id, req));
    }
}
