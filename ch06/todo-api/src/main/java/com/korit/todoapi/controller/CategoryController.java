package com.korit.todoapi.controller;

import com.korit.todoapi.dto.ApiResponse;
import com.korit.todoapi.dto.CreateResponse;
import com.korit.todoapi.dto.category.CategoryModifyReq;
import com.korit.todoapi.dto.category.CategoryReq;
import com.korit.todoapi.entity.CategoryCompletionCount;
import com.korit.todoapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CreateResponse>> create(@RequestBody CategoryReq dto) {
        return ResponseEntity.ok(ApiResponse.success(categoryService.create(dto)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAll(@AuthenticationPrincipal Long userId) {
        return ResponseEntity.ok(ApiResponse.success(categoryService.getAll(userId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> modify(@PathVariable Long id,  @RequestBody CategoryModifyReq dto){
        categoryService.modify(dto);
        return ResponseEntity.ok(ApiResponse.success("수정 완료"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("삭제 완료"));
    }

    @GetMapping("/count/completion/not")
    public ResponseEntity<ApiResponse<List<CategoryCompletionCount>>> notCompleted(@AuthenticationPrincipal Long userId) {
        return ResponseEntity.ok(ApiResponse.success(categoryService.getNotCompletedCount(userId)));
    }
}
