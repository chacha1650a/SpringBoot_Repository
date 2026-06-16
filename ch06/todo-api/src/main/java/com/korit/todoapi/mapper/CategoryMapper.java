package com.korit.todoapi.mapper;

import com.korit.todoapi.entity.Category;
import com.korit.todoapi.entity.CategoryCompletionCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int insert(Category category);

    Category selectByNameAndUserId(String categoryName, Long userId);
    Category selectById(Long id);

    List<Category> selectAllByUserId(Long userId);

    int update(Category category);
    int delete(Long id);

    List<CategoryCompletionCount> countNotCompletedByUserId(Long userId);
}