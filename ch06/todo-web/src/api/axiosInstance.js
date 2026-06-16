import axios from "axios";

export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 5000,
});

// 매 요청마다 localStorage에 accessToken이 존재한다면, "Bearer를 붙여서 토큰을 가지고 들어감."
axiosInstance.interceptors.request.use((config) => {
    const token = localStorage.getItem("accessToken");
    if (!!token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

// 응답 때 accessToken이 올바르지 않을 경우 기존의 token을 삭제,
// singin 페이지로 이동 시킨다.
axiosInstance.interceptors.response.use(
    (response) => response, 
    (error) => {
        if (error.response.status === 401) {
            localStorage.removeItem("accessToken");
            window.location.href = "/auth/login";
        }
        return Promise.reject(error);
    }
);