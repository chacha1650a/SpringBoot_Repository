import { useMutation, useQueryClient } from "@tanstack/react-query"
import { registerTodo, updatedCompletion } from "../../api/todoApi";

export const useTodoRegisterMutation = () => {

    return useMutation({
        mutationFn: (data) => registerTodo(data),
        onSuccess: (response) => {

        },
        onError: (error) => {
            alert(error.message);
        }
    });
}


export const useTodoCompleteMutaion = () => {
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: (data) => updatedCompletion(data),
        onSuccess: (response) => {
            queryClient.invalidateQueries(["todoList"]);
        },
        onError: (error) => {
            alert(error.message);
        }
    });
}