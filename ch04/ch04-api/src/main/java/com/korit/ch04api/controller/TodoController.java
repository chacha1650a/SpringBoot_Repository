package com.korit.ch04api.controller;

import com.korit.ch04api.dto.ApiResponse;
import com.korit.ch04api.dto.TodoRequest;
import com.korit.ch04api.dto.TodoResponse;
import com.korit.ch04api.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<ApiResponse<TodoResponse>> createTodo(@Valid @RequestBody TodoRequest request) {
        return ResponseEntity.ok(ApiResponse.success(todoService.createTodo(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TodoResponse>>> getTodos() {
        return ResponseEntity.ok(ApiResponse.success(todoService.getTodos()));
    }

    @PatchMapping("/{todoId}/done")
    public ResponseEntity<ApiResponse<Void>> toggleTodoDone(@PathVariable int todoId) {
        todoService.toggleTodoDone(todoId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<ApiResponse<Void>> deleteTodo(@PathVariable int todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
