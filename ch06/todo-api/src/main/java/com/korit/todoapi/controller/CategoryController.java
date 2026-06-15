package com.korit.todoapi.controller;

import com.korit.todoapi.dto.CategoryReq;
import com.korit.todoapi.dto.CategoryResp;
import com.korit.todoapi.entity.Category;
import com.korit.todoapi.security.OAuth2SuccessHandler;
import com.korit.todoapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResp> createCategory( @AuthenticationPrincipal Long userId, @RequestBody CategoryReq categoryReq) {
        return ResponseEntity.ok(categoryService.createCategory(userId, categoryReq));
    }

    @GetMapping
    public ResponseEntity<?> get(@AuthenticationPrincipal Long userId) {
//        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(categoryService.getCategoriesByUserId(userId));
    }

    @GetMapping("/count/completion/not")
    public ResponseEntity<?> notCompleted(@AuthenticationPrincipal Long userId) {

        return ResponseEntity.ok(categoryService.categoryCompleted(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@AuthenticationPrincipal Long userId, @PathVariable Long id, @RequestBody CategoryReq req){

        return ResponseEntity.ok(categoryService.updateCategory(userId, id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@AuthenticationPrincipal Long userId, @PathVariable Long id){
        categoryService.deleteCategory(userId, id);
        return ResponseEntity.noContent().build();
    }


}
