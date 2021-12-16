import React from 'react';
import {Navigate, Route, Routes} from 'react-router-dom';
import LoginPage from 'app/logic/login/LoginPage';
import PizzaOrdersPage from 'app/logic/PizzaOrdersPage';
import AuthProvider from 'app/AuthProvider';
import './App.css';
import 'antd/dist/antd.css';

function App() {
    return (
        <AuthProvider>
            <Routes>
                <Route path='login' element={<LoginPage/>}/>
                <Route path='pizza-orders' element={<PizzaOrdersPage/>}/>
                <Route path='*' element={<Navigate to='/login'/>}/>
            </Routes>
        </AuthProvider>
    );
}


export default App;
