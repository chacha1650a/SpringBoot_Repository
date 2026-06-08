package com.korit.ch04api.mapper;

import com.korit.ch04api.entity.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodoMapper {
    void createTableIfNotExists();
    
    int insertTodo(Todo todo);
    
    List<Todo> selectTodosByUserId(int userId);
    
    Todo selectTodoById(int todoId);
    
    int updateTodoStatus(@Param("todoId") int todoId, @Param("done") boolean done);
    
    int deleteTodo(int todoId);
}
