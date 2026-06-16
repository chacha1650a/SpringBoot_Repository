package com.korit.todoapi.mapper;

import com.korit.todoapi.entity.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    int insert(Todo todo);

    List<Todo> selectAll();
    Todo selectById(Long id);

    int update(Todo todo);
    int updateCompleted(Long  id, boolean isCompleted);
    int delete(Long id);
}
