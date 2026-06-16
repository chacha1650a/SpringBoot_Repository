package com.korit.todoapi.service;

import com.korit.todoapi.common.exception.DuplicatedException;
import com.korit.todoapi.dto.CreateResponse;
import com.korit.todoapi.dto.category.CategoryModifyReq;
import com.korit.todoapi.dto.category.CategoryReq;
import com.korit.todoapi.dto.category.CategoryResp;
import com.korit.todoapi.entity.Category;
import com.korit.todoapi.entity.CategoryCompletionCount;
import com.korit.todoapi.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    private void checkDuplicate(String categoryName, Long userId) {
        Category category = categoryMapper.selectByNameAndUserId(categoryName, userId);
        if (category != null) {
            throw new DuplicatedException("이미 존재하는 카테고리입니다", "name", categoryName);
        }
    }

    public CreateResponse create(CategoryReq req) {
        checkDuplicate(req.getName(), req.getUserId());

        Category category = req.toCategory();
        categoryMapper.insert(category);

        return CreateResponse.builder()
                .domainName("category")
                .createdIds(List.of(category.getId()))
                .build();
    }

    public List<CategoryResp> getAll(Long userId) {
        return categoryMapper.selectAllByUserId(userId)
                .stream()
                .map(Category::toResponse)
                .toList();
    }

    public void modify(CategoryModifyReq dto) {
        checkDuplicate(dto.getName(), dto.getUserId());
        categoryMapper.update(dto.toCategory());
    }

    public void delete(Long id) {
        categoryMapper.delete(id);
    }
    public List<CategoryCompletionCount> getNotCompletedCount(Long userId) {
        return categoryMapper.countNotCompletedByUserId(userId);
    }

}
