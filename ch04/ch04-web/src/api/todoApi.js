import { axiosInstance } from "./axiosInstance";

export const createTodo = async (todoData) => {
    const response = await axiosInstance.post("/api/todos", todoData);
    return response.data;
};

export const getTodos = async () => {
    const response = await axiosInstance.get("/api/todos");
    return response.data;
};

export const toggleTodoDone = async (todoId) => {
    const response = await axiosInstance.patch(`/api/todos/${todoId}/done`);
    return response.data;
};

export const deleteTodo = async (todoId) => {
    const response = await axiosInstance.delete(`/api/todos/${todoId}`);
    return response.data;
};
