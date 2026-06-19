import axios from "axios";

export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 5000,
});

// interceptor로 요청 도중 accessToken 주입 : Callback
axiosInstance.interceptors.request.use((config) => {
    const token = localStorage.getItem("accessToken");
    if (!!token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

// interceptor로 응답 도중 401 에러가 발생시 로그인 화면으로 리턴 : Callback
axiosInstance.interceptors.response.use(
    (response) => response, 
    (error) => {
        if (error.response.status === 401) {
            localStorage.removeItem("accessToken");
            // window.location.href = "/auth/login";
        }
        return Promise.reject(error);
    }
);