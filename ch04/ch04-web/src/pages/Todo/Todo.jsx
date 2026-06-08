import React, { useState, useEffect } from 'react';
import { createTodo, getTodos, toggleTodoDone, deleteTodo } from '../../api/todoApi';
import * as s from './styles';

const Todo = () => {
    const [todos, setTodos] = useState([]);
    const [title, setTitle] = useState('');
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        fetchTodos();
    }, []);

    const fetchTodos = async () => {
        try {
            const data = await getTodos();
            if (data.success) {
                setTodos(data.body || []);
            }
        } catch (error) {
            console.error("Failed to fetch todos", error);
            alert("할 일 목록을 불러오는데 실패했습니다.");
        }
    };

    const handleAddTodo = async (e) => {
        e.preventDefault();
        if (!title.trim()) return;

        try {
            setLoading(true);
            const data = await createTodo({ title });
            if (data.success) {
                setTitle('');
                fetchTodos();
            }
        } catch (error) {
            console.error("Failed to add todo", error);
            alert("할 일 추가에 실패했습니다.");
        } finally {
            setLoading(false);
        }
    };

    const handleToggleDone = async (todoId) => {
        try {
            const data = await toggleTodoDone(todoId);
            if (data.success) {
                fetchTodos();
            }
        } catch (error) {
            console.error("Failed to update todo status", error);
        }
    };

    const handleDelete = async (todoId) => {
        if (!window.confirm("정말 삭제하시겠습니까?")) return;
        
        try {
            const data = await deleteTodo(todoId);
            if (data.success) {
                fetchTodos();
            }
        } catch (error) {
            console.error("Failed to delete todo", error);
        }
    };

    return (
        <div css={s.container}>
            <h2 css={s.header}>My Todo List</h2>
            
            <form css={s.inputGroup} onSubmit={handleAddTodo}>
                <input 
                    type="text" 
                    placeholder="새로운 할 일을 입력하세요..." 
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    disabled={loading}
                />
                <button type="submit" disabled={loading}>추가</button>
            </form>

            <ul css={s.todoList}>
                {todos.map(todo => (
                    <li key={todo.todoId} css={s.todoItem(todo.done)}>
                        <div className="content-wrapper">
                            <input 
                                type="checkbox" 
                                checked={todo.done}
                                onChange={() => handleToggleDone(todo.todoId)}
                            />
                            <span>{todo.title}</span>
                        </div>
                        <button onClick={() => handleDelete(todo.todoId)}>삭제</button>
                    </li>
                ))}
                {todos.length === 0 && (
                    <li style={{ textAlign: 'center', color: '#6b7280', padding: '20px' }}>
                        등록된 할 일이 없습니다.
                    </li>
                )}
            </ul>
        </div>
    );
};

export default Todo;
