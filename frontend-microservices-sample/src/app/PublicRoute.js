import React from 'react'
import { Routes, Route, Navigate } from "react-router-dom";
import { LayoutSplashScreen } from '../_metronic/layout';
import { LayoutInit } from './modules/layout'; 
import { Home } from './modules/pages';


export default function PublicRoute() {

    const ChatPage = () => {
        return (
            <div id="kt_content_container" className='max-screen bg-white'>
                <h3 className='text-dark text-center'>test 123</h3>
            </div>
        );
    }


    return (
        <React.Suspense fallback={<LayoutSplashScreen />}>
            <Routes>
                <Route path="/home" element={<LayoutInit><Home /></LayoutInit>} />
                <Route path="/chat" element={<LayoutInit><ChatPage /></LayoutInit>} />
                <Route path='*' element={<Navigate to='/error' />} />
                <Route index element={<Navigate to='/home' />} />
            </Routes>
        </React.Suspense>
    )
}
