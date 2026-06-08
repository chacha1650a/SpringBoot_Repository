import { api } from "./axiosInstance";

export const createTodo = async (todoData) => {
    const response = await api.post("/todos", todoData);
    return response.data;
};

export const getTodos = async () => {
    const response = await api.get("/todos");
    return response.data;
};

export const toggleTodoDone = async (todoId) => {
    const response = await api.patch(`/todos/${todoId}/done`);
    return response.data;
};

export const deleteTodo = async (todoId) => {
    const response = await api.delete(`/todos/${todoId}`);
    return response.data;
};
