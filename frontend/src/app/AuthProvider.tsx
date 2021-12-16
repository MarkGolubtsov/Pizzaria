import React, {createContext, PropsWithChildren, useEffect, useState} from 'react';
import {UserService} from 'app/service/UserService';
import {constants} from 'app/constants';
import {useNavigate} from 'react-router-dom';


export const AuthContext = createContext<AuthStore>({
    token: '',
    login: () => {
        return Promise.resolve();
    },
    logout: () => {
    },
})

type AuthStore = {
    token: string,
    login: (username: string, password: string) => Promise<void>,
    logout: () => void;
}

export default function AuthProvider(props: PropsWithChildren<any>) {
    const [token, setToken] = useState('');

    const navigate = useNavigate();

    useEffect(() => {
        setToken(localStorage.getItem(constants.TOKEN_STORAGE_KEY) ?? '');
    }, []);

    return (
        <AuthContext.Provider value={{
            token,
            login,
            logout
        }}>
            {props.children}
        </AuthContext.Provider>
    )

    function login(username: string, password: string) {
        return UserService.login(username, password).then(({token}: { token: string }) => {
            localStorage.setItem(constants.TOKEN_STORAGE_KEY, token);
            setToken(token);
        })
    }

    function logout() {
        setToken('');
        localStorage.removeItem(constants.TOKEN_STORAGE_KEY);
        navigate('/login')
    }
}
