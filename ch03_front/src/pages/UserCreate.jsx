import { useState } from "react"
import axios from "axios";

function UserCreate() {
    const emptyUser = {
        username: "",
        password: "",
        name: "",
        email: "",
    }
    const [ inputValues, setInputValues ] = useState(emptyUser);

    const handleInputOnChange = (e) => {
        setInputValues(prev => ({
            ...prev,
            [e.target.name]: e.target.value,
        }));
    }

    const handleRegisterPromiseOnClick = () => {
        axios.post("http://localhost:8080/api/users", inputValues)
        .then((response) => {console.log(response)})
        .catch((error) => {console.log(error.response)})

    }

    const handleRegisterAsyncOnClick = async () => {
        try {
            const response = await axios.post("http://localhost:8080/api/users", inputValues)

        } catch (error) {
            response = error.response;
        }
        console.log(response);

    }

    return (
        <>
            <div>
                <input type="text" name="username" placeholder="사용자이름" value={inputValues.username} onChange={handleInputOnChange}/>
            </div>
            <div>
                <input type="password" name="password" placeholder="비밀번호" value={inputValues.password} onChange={handleInputOnChange}/>
            </div>
            <div>
                <input type="text" name="name" placeholder="성명" value={inputValues.name} onChange={handleInputOnChange}/>
            </div>
            <div>
                <input type="text" name="email" placeholder="이메일" value={inputValues.email} onChange={handleInputOnChange}/>
            </div>
            <div>
                <button onClick={handleRegisterPromiseOnClick}>Promise 등록</button>
                <button onClick={handleRegisterAsyncOnClick}>Async 등록</button>
            </div>
        </>
    )
}

export default UserCreate;