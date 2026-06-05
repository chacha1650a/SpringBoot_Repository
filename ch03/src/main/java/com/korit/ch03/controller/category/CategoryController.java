package com.korit.ch03.controller.category;

import com.korit.ch03.controller.dto.ApiResponse;
import com.korit.ch03.controller.dto.CategoryReqCreate;
import com.korit.ch03.controller.dto.CategoryResp;
import com.korit.ch03.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody CategoryReqCreate dto) {
        categoryService.create(dto);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResp>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok(categoryService.getAll()));
    }

    @GetMapping("/api/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResp>> getOne(@PathVariable Long categoryId) {
        return ResponseEntity.ok(ApiResponse.ok(categoryService.getOne(categoryId)));
    }

    @GetMapping("/api/{categoryName}")
    public ResponseEntity<ApiResponse<CategoryResp>> getOne(@PathVariable String categoryName) {
        return ResponseEntity.ok(ApiResponse.ok(categoryService.getOne(categoryName)));
    }
}
