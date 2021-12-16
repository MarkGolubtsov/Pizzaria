import React from 'react'
import {Button, Layout} from 'antd';
import {Content, Header} from 'antd/es/layout/layout';
import useAuth from 'app/useAuth';
import {Outlet} from 'react-router-dom';
import 'app/logic/PrivatePageLayout.css';

export default function PrivatePageLayout() {
    const {logout} = useAuth();

    return (
        <Layout>
            <Header className='page-header'>
                <Button danger type='primary' onClick={logout}>
                    Logout
                </Button>
            </Header>
            <Content>
                <Outlet/>
            </Content>
        </Layout>
    )
}
