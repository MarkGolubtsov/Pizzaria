import React from 'react';
import 'antd/dist/antd.css';
import {Navigate, Route, Routes} from 'react-router-dom';
import LoginPage from 'app/logic/login/LoginPage';
import PizzaOrdersPage from 'app/logic/PizzaOrdersPage';
import AuthProvider from 'app/AuthProvider';
import PrivatePageLayout from 'app/logic/PrivatePageLayout';
import './App.css';

function App() {
    return (
        <AuthProvider>
            <Routes>
                <Route path='login' element={<LoginPage/>}/>
                <Route path='pizza-orders' element={<PrivatePageLayout/>}>
                    <Route index element={<PizzaOrdersPage/>}/>
                </Route>
                <Route path='*' element={<Navigate to='/login'/>}/>
            </Routes>
        </AuthProvider>
    );
}


export default App;
