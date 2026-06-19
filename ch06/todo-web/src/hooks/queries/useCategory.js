import { useQuery, useQueryClient } from "@tanstack/react-query"
import { getCategoriesRequest, getCategoryColorsAndIcons, getCategoryNotCompletedCount } from "../../api/categoryApis";

// react-query : 서버 전역 상태(+ 캐싱)
// useQuery로 데이터를 캐싱해둠
// 해당 값이 비어 있다면 백엔드에서 자동 갱신 해옴
// userQuery는 데이터 강제 만료 후 DB에서 데이터를 갱신함 (캐싱이 비었을 때 자동 요청)
// mutation은 수정 요청으로 직접 해야함.
export const useCategories = () => {

    return useQuery({
        queryKey: ["categories"],
        queryFn: getCategoriesRequest,
        staleTime: 1000 * 60 * 60 * 24,
        gcTime: 1000 * 60 * 60 * 24,
    });
}

export const useCategoryColorsAndIcons = () => {
    return useQuery({
        queryKey: ["categoryColorsAndIcons"],
        queryFn: getCategoryColorsAndIcons,
        staleTime: 1000 * 60 * 60 * 24,
        gcTime: 1000 * 60 * 60 * 24,
    });
}

export const useCategoryNotCompletedCount = () => {
    const categoriesQuery = useCategories();

    return useQuery({
        queryKey: ["categoryNotCompletedCount"],
        queryFn: getCategoryNotCompletedCount,
        staleTime: 1000 * 60 * 60 * 24,
        gcTime: 1000 * 60 * 60 * 24,
        enabled: !!categoriesQuery.data,
    });
}