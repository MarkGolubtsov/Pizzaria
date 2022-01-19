import React from 'react';
import {Button, Form, Input} from 'antd';
import AppForm from 'app/components/AppForm';
import useAuth from 'app/useAuth';
import {Navigate, useNavigate} from 'react-router-dom';
import 'app/logic/login/LoginPage.css';

export default function LoginPage() {

    const initialValues = {
        login: '',
        password: ''
    }

    const {login: loginInToApp} = useAuth();
    const navigate = useNavigate();
    const auth = useAuth();

    //todo refactoring!!!!!!!
    if (auth.token) {
        return <Navigate to={'/pizza/orders'}/>
    }

    return (
        <div className='login-page'>
            <AppForm onFinish={handleSubmit} initialValues={initialValues}
                     className='login-form'
                     layout='vertical' name='login-form'>
                <Form.Item name='login' label='Электронная почта' rules={[{required: true, message: 'Электронная почта обязательна'}]}>
                    <Input type='text' placeholder='Электронная почта'/>
                </Form.Item>
                <Form.Item name='password' label='Пароль' rules={[{required: true, message: 'Пароль обязателен'}]}>
                    <Input.Password placeholder='Пароль'/>
                </Form.Item>
                <Form.Item>
                    <Button type='primary' htmlType='submit'>
                        Логин
                    </Button>
                </Form.Item>
            </AppForm>
        </div>
    )

    function handleSubmit({login, password}: { login: string, password: string }) {
        loginInToApp(login, password).then(() => {
                navigate('/pizza/orders');
            }
        );
    }
}
