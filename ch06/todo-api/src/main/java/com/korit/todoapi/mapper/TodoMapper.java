package com.korit.todoapi.mapper;

import com.korit.todoapi.entity.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    int insert(Todo todo);

    List<Todo> selectByUserId();
    Todo selectById(Long id);

    int updateTodo(Todo todo);
    int deleteTodo(Long id);
}
