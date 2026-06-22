import { useQuery } from "@tanstack/react-query"
import { getTodoList } from "../../api/todoApi"

export const useTodoList = () => {

    return useQuery({
        queryKey: ["todoList"],
        queryFn: getTodoList,
        staleTime: 1000 * 60 * 60 * 24,
        gcTime: 1000 * 60 * 60 * 24,
    });
}