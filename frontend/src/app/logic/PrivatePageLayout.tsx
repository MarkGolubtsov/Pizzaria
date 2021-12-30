import React from 'react'
import {Button, Layout} from 'antd';
import {Content, Header} from 'antd/es/layout/layout';
import useAuth from 'app/useAuth';
import {Outlet, useLocation, useNavigate} from 'react-router-dom';
import 'app/logic/PrivatePageLayout.css';

export default function PrivatePageLayout() {
    const {logout} = useAuth();
    const navigate = useNavigate();
    const pathname = useLocation().pathname;

    const isPizzaActive = pathname === '/pizza';
    const isOrdersActive = pathname === '/pizza/orders';

    const getCssHeaderActiveClass = (act: boolean) => act ? 'header-link-active' : '';
    return (
        <Layout>
            <Header className='page-header'>
                <div className='page-links'>
                    <div onClick={navigateToPizza}
                         className={`header-link pizza-link ${getCssHeaderActiveClass(isPizzaActive)}`}>
                        Pizza
                    </div>
                    <div onClick={navigateToOrders}
                         className={`header-link pizza-orders-link ${getCssHeaderActiveClass(isOrdersActive)}`}>
                        Orders
                    </div>
                </div>
                <Button danger type='primary' onClick={logout}>
                    Logout
                </Button>
            </Header>
            <Content>
                <Outlet/>
            </Content>
        </Layout>
    )

    function navigateToOrders() {
        navigate('/pizza/orders')
    }

    function navigateToPizza() {
        navigate('/pizza')
    }
}
