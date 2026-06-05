package com.korit.ch03.service;

import com.korit.ch03.controller.dto.CategoryReqCreate;
import com.korit.ch03.controller.dto.CategoryResp;
import com.korit.ch03.entity.Category;
import com.korit.ch03.exception.DuplicatedException;
import com.korit.ch03.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public void create(CategoryReqCreate dto) {

        Category foundCategory = categoryMapper.selectByCategoryName(dto.getCategoryName());
        if (foundCategory != null) {
            throw new DuplicatedException("카테고리 이름이 이미 존재합니다.", "categoryName", dto.getCategoryName());
        }

        Category newCategory = Category.builder()
                .categoryName(dto.getCategoryName())
                .build();

        categoryMapper.insert(newCategory);
    }

    public List<CategoryResp> getAll() {
        List<Category> categories = categoryMapper.selectAll();
        return categories.stream()
                .map(category -> CategoryResp.builder()
                        .id(category.getId())
                        .categoryName(category.getCategoryName())
                        .createdAt(category.getCreatedAt())
                        .updatedAt(category.getUpdatedAt())
                        .build())
                .toList();
    }

    public CategoryResp getOne(Long categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        return CategoryResp.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .build();
    }

    public CategoryResp getOne(String categoryName) {
        Category category = categoryMapper.selectByCategoryName(categoryName);
        return CategoryResp.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .build();
    }
}
