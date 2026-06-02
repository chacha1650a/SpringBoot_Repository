import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router";

function UserDetails() {

    const { userId } = useParams();
    const emptyUser = {
        id: "",
        username: "",
        name: "",
        email: "",
        roles: [],
    }
    const [ user, setUser ] = useState({});

    const getUserReq = async () => {
        let response = null;

        try {
            response = await axios.get(`http://localhost:8080/api/users/${userId}`)
        } catch (error) {
            response = error.response;
        }
        setUser(response.data.body);
    }

    useEffect(() => {
        getUserReq();
    }, []);

    return (
        <>
            <ul>
                <li>ID: {user.id}</li>
                <li>사용자이름: {user.username}</li>
                <li>성명: {user.name}</li>
                <li>이메일: {user.email}</li>
                <li>
                    권한: 
                    <ol>
                        {user.roles.map(role => <li key={roleId}>{role.roleName}</li>)}
                    </ol>
                </li>
            </ul>
        </>
    )
}

export default UserDetails;