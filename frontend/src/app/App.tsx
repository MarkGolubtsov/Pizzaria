import React, {useEffect} from 'react';
import 'antd/dist/antd.css';
import {Navigate, Route, Routes} from 'react-router-dom';
import LoginPage from 'app/logic/login/LoginPage';
import PizzaOrdersPage from 'app/logic/orders/PizzaOrdersPage';
import AuthProvider from 'app/AuthProvider';
import PrivatePageLayout from 'app/logic/PrivatePageLayout';
import PizzaPage from 'app/logic/pizza/PizzaPage';
import CartPage from 'app/logic/cart/CartPage';
import CartProvider from 'app/logic/CartProvider';
import {message} from 'antd';
import './App.css';
import {ApiError} from 'app/api/ApiError';

function App() {
    useEffect(() => {
        setUnhandledErrorsProcessing();
    }, [])
    return (
        <CartProvider>
            <AuthProvider>
                <Routes>
                    <Route path='login' element={<LoginPage/>}/>
                    <Route path='pizza' element={<PrivatePageLayout/>}>
                        <Route index element={<PizzaPage/>}/>
                        <Route path='orders' element={<PizzaOrdersPage/>}/>
                        <Route path='cart' element={<CartPage/>}/>
                    </Route>
                    <Route path='*' element={<Navigate to='/login'/>}/>
                </Routes>
            </AuthProvider>
        </CartProvider>
    );
}

/**
 * Handle async errors.
 */
function setUnhandledErrorsProcessing() {
    window.addEventListener('unhandledrejection', (event: any) => {
        const error = event.reason;
        if (error instanceof ApiError && !!error.message) {
            message.error(error.message, 4);
            return;
        }
    });
}


export default App;
