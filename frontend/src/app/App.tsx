import React from 'react';
import 'antd/dist/antd.css';
import {Navigate, Route, Routes} from 'react-router-dom';
import LoginPage from 'app/logic/login/LoginPage';
import PizzaOrdersPage from 'app/logic/PizzaOrdersPage';
import AuthProvider from 'app/AuthProvider';
import PrivatePageLayout from 'app/logic/PrivatePageLayout';
import './App.css';
import PizzaPage from 'app/logic/pizza/PizzaPage';

function App() {
    return (
        <AuthProvider>
            <Routes>
                <Route path='login' element={<LoginPage/>}/>
                <Route path='pizza' element={<PrivatePageLayout/>}>
                    <Route index element={<PizzaPage/>}/>
                    <Route path='orders' element={<PizzaOrdersPage/>}/>
                </Route>
                <Route path='*' element={<Navigate to='/login'/>}/>
            </Routes>
        </AuthProvider>
    );
}


export default App;
