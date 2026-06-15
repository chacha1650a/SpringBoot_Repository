package com.korit.todoapi.service;

import com.korit.todoapi.common.exception.DuplicatedException;
import com.korit.todoapi.dto.CategoryReq;
import com.korit.todoapi.dto.CategoryResp;
import com.korit.todoapi.dto.categoryCompletionCountResp;
import com.korit.todoapi.entity.Category;
import com.korit.todoapi.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public CategoryResp createCategory(Long userId, CategoryReq req) {

        Category foundCategory = categoryMapper.selectByUsername(req.getName());

        if (foundCategory != null) {
            throw new DuplicatedException("카테고리 명이 중복됩니다.", "categoryName", req.getName());
        }

        Category category = Category.builder()
                .userId(userId)
                .name(req.getName())
                .color(req.getColor())
                .icon(req.getIcon())
                .build();

        categoryMapper.insert(category);
        return CategoryResp.fromEntity(category);
    }

    public List<CategoryResp> getCategoriesByUserId(Long userId) {
        return categoryMapper.selectByUserId(userId).stream()
                .map(CategoryResp::fromEntity)
                .collect(Collectors.toList());
    }

    public CategoryResp updateCategory(Long userId, Long categoryId, CategoryReq req){

        Category category = categoryMapper.selectById(categoryId);
        if (category == null || !category.getUserId().equals(userId)) {
            throw new IllegalArgumentException("카테고리를 찾을 수 없거나 권한이 없습니다.");
        }

        Category foundCategory = categoryMapper.selectByUsername(req.getName());

        if (foundCategory != null) {
            throw new DuplicatedException("중복되는 카테고리명입니다.", "categoryName", req.getName());
        }

        category.setName(req.getName());
        category.setColor(req.getColor());
        category.setIcon(req.getIcon());

        categoryMapper.update(category);
        return CategoryResp.fromEntity(category);
    }

    public void deleteCategory(Long userId, Long categoryId){
        Category category = categoryMapper.selectById(categoryId);

        if (category == null || !category.getUserId().equals(userId)) {
            throw new IllegalArgumentException("카테고리를 찾을 수 없거나 권한이 없습니다.");
        }

        categoryMapper.delete(categoryId);
    }


    public List<categoryCompletionCountResp> categoryCompleted(Long userId) {
        return categoryMapper.countNotCompletedByUserId(userId).stream()
                .map(categoryCompletionCountResp::fromEntity)
                .collect(Collectors.toList());
    }
}
