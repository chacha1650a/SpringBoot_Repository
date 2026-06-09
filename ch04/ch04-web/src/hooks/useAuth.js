import { useMutation, useQueryClient } from "@tanstack/react-query";
import { useNavigate } from "react-router";
import { signIn, signUp } from "../api/authApi";
import { useAuthStore } from "../store/authStore";

export function useSignUp() {
    const nvigate = useNavigate();

    return useMutation({
        mutationFn: (signUpData) => signUp(signUpData),
        onSuccess: () => {
            alert("회원가입 성공! 로그인 해주세요.");
            nvigate("/auth/signin");
        },
        onError: (error) => {
            const message = error.response.data.body.message;
            alert(message);
        }
    });
}

export function useSignIn() {
    const nvigate = useNavigate();
    const saveToken = useAuthStore((state) => state.saveToken);
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: (signInData) => signIn(signInData),
        onSuccess: (data) => {
            saveToken(data.body.accessToken);
            queryClient.invalidateQueries();
            nvigate("/");
        },
        onError: (error) => {
            const message = error.response.data.body.message;
            alert(message);
        }
    })
}