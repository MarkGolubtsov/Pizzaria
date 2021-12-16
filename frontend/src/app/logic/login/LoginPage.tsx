import React from 'react';
import {Button, Form, Input} from 'antd';
import AppForm from 'app/components/AppForm';
import 'app/logic/login/LoginPage.css';
import useAuth from 'app/useAuth';
import {useNavigate} from 'react-router-dom';

export default function LoginPage() {

    const initialValues = {
        login: '',
        password: ''
    }
    const {login: loginInToApp} = useAuth();
    const navigate = useNavigate();

    return (
        <div className='login-page'>
            <AppForm onFinish={handleSubmit} initialValues={initialValues}
                     className='login-form'
                     layout='vertical' name='login-form'>
                <Form.Item name='login' label='Login' rules={[{required: true, message: 'Login is required'}]}>
                    <Input type='text' placeholder='Login'/>
                </Form.Item>
                <Form.Item name='password' label='Password' rules={[{required: true, message: 'Password is required'}]}>
                    <Input.Password placeholder='Password'/>
                </Form.Item>
                <Form.Item>
                    <Button type='primary' htmlType='submit'>
                        Log in
                    </Button>
                </Form.Item>
            </AppForm>
        </div>
    )

    function handleSubmit({login, password}: { login: string, password: string }) {
        loginInToApp(login, password).then(() => {
                navigate('/pizza-orders');
            }
        );
    }
}
