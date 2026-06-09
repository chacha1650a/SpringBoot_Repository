import { useState } from "react";
import { Link } from "react-router";
import { useSignIn } from "../../hooks/useAuth";
import * as s from "./styles";

function SignIn() {
    const emptyInputValues = {
        username: "",
        password: "",
    };

    const [ inputValues, setInputValues ] = useState(emptyInputValues);

    const signInMutation = useSignIn();

    const handleInputOnChange = (e) => {
        setInputValues(prev => ({
            ...prev,
            [e.target.name]: e.target.value,
        }));
    }

    const handleSignInOnClick = () => {
        signInMutation.mutateAsync(inputValues);
        setInputValues(emptyInputValues);
    }


    return (
        <div css={s.cardWrapper}>
            <div css={s.cardContent}>
                <h1>로그인</h1>
                <div css={s.inputGroup}>
                    <input type="text" name="username" placeholder="사용자이름" value={inputValues.username} onChange={handleInputOnChange} />
                </div>
                <div css={s.inputGroup}>
                    <input type="password" name="password" placeholder="비밀번호" value={inputValues.password} onChange={handleInputOnChange} />
                </div>
                <div css={s.buttonGroup}>
                    <button onClick={handleSignInOnClick}>로그인</button>
                </div>
                <div css={s.linkText}>
                    계정이 없으신가요? <Link to={"/auth/signup"}>회원가입</Link>
                </div>
            </div>
        </div>
    )
}

export default SignIn;
