import { useEffect, useState } from "react";
import { Link } from "react-router";
import { useSignUp } from "../../hooks/useAuth";
import * as s from "./styles";

function SignUp() {
    const REGEX = {
        username: /^[a-z][a-z0-9_]{3,19}$/,
        password: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,20}$/,
        name: /^[가-힣]{2,10}$|^[a-zA-Z\s]{2,30}$/,
        email: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/,
    };

    const emptyInputs = {
        username: "",
        password: "",
        confirmPassword: "",
        name: "",
        email: "",
    }

    const [inputValues, setInputValues] = useState(emptyInputs);
    const [inputErrors, setInputErrors] = useState(emptyInputs);
    const [signUpDisabled, setSignUpDisabled] = useState(true);

    const signUpMutation = useSignUp();

    const handleInputOnChange = (e) => {
        setInputValues(prev => ({
            ...prev,
            [e.target.name]: e.target.value,
        }));
    }

    const handleSignUpOnClick = async () => {
        await signUpMutation.mutateAsync(inputValues);
        setInputValues(emptyInputs);
    }

    const validate = ({ username, password, confirmPassword, name, email }) => {
        const errors = {};

        if (!REGEX.username.test(username) && !!username) {
            errors.username = "영문 소문자로 시작, 4~20자 (숫자, 특수문자 -, _ 포함 가능)";
        }
        if (!REGEX.password.test(password) && !!password) {
            errors.password = "영문, 숫자, 특수문자 포함 8~20자";
        }
        if (password !== confirmPassword && !!confirmPassword) {
            errors.confirmPassword = "비밀번호가 일치하지 않습니다.";
        }
        if (!REGEX.name.test(name) && !!name) {
            errors.name = "이름을 정확히 입력해 주세요.";
        }
        if (!REGEX.email.test(email) && !!email) {
            errors.email = "올바른 이메일 형식이 아닙니다.";
        }

        return errors;
    }

    useEffect(() => {
        setInputErrors(validate(inputValues));
    }, [inputValues]);

    useEffect(() => {
        const inputEmptyValuesEntries = Object.values(inputValues).filter(value => !value);
        const inputErrosEntries = Object.entries(inputErrors).filter(([_, v]) => v);
        setSignUpDisabled(inputEmptyValuesEntries.length > 0 || inputErrosEntries.length > 0);
    }, [inputErrors, inputValues]);

    return (
        <div css={s.cardWrapper}>
            <div css={s.cardContent}>
                <h1>회원가입</h1>
                <div css={s.inputGroup}>
                    <input type="text" name="username" onChange={handleInputOnChange} value={inputValues.username} placeholder="사용자이름" />
                </div>
                {inputErrors.username && <div css={s.errorText}>{inputErrors.username}</div>}
                
                <div css={s.inputGroup}>
                    <input type="password" name="password" onChange={handleInputOnChange} value={inputValues.password} placeholder="비밀번호" />
                </div>
                {inputErrors.password && <div css={s.errorText}>{inputErrors.password}</div>}
                
                <div css={s.inputGroup}>
                    <input type="password" name="confirmPassword" onChange={handleInputOnChange} value={inputValues.confirmPassword} placeholder="비밀번호 확인" />
                </div>
                {inputErrors.confirmPassword && <div css={s.errorText}>{inputErrors.confirmPassword}</div>}
                
                <div css={s.inputGroup}>
                    <input type="text" name="name" onChange={handleInputOnChange} value={inputValues.name} placeholder="이름" />
                </div>
                {inputErrors.name && <div css={s.errorText}>{inputErrors.name}</div>}
                
                <div css={s.inputGroup}>
                    <input type="text" name="email" onChange={handleInputOnChange} value={inputValues.email} placeholder="이메일" />
                </div>
                {inputErrors.email && <div css={s.errorText}>{inputErrors.email}</div>}
                
                <div css={s.buttonGroup}>
                    <button disabled={signUpDisabled} onClick={handleSignUpOnClick}>회원가입</button>
                </div>
                
                <div css={s.linkText}>
                    이미 계정이 있으신가요? <Link to={"/auth/signin"}>로그인</Link>
                </div>
            </div>
        </div>
    )
}

export default SignUp;
