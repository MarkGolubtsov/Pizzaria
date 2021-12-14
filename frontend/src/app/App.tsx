import React from 'react';
import {Navigate, Route, Routes} from 'react-router-dom';
import LoginPage from 'app/logic/LoginPage';
import './App.css';
import 'antd/dist/antd.css';

function App() {
    return (
        <Routes>
            <Route path='login' element={<LoginPage/>}/>
            <Route path='*' element={<Navigate to='/login'/>}/>
        </Routes>
    );
}

export default App;
