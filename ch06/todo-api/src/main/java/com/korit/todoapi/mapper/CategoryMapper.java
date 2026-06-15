package com.korit.todoapi.mapper;

import com.korit.todoapi.entity.Category;
import com.korit.todoapi.entity.CategoryCompletionCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int insert(Category category);
    Category selectByUsername(String categoryName);

    List<Category> selectByUserId(Long userId);
    Category selectById(Long id);
    int update(Category category);
    int delete(Long id);

    List<CategoryCompletionCount> countNotCompletedByUserId(Long userId);
}