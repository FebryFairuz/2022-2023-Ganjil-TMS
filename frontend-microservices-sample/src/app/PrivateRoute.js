import React from 'react'
import { Routes, Route, Navigate } from "react-router-dom";
import { LayoutSplashScreen } from "../_metronic/layout";
import { LayoutInit } from './modules/layout';
import { Home } from './modules/pages';

export default function PrivateRoute() {
    const ChatPage = () => {
        return <h3>Chat page</h3>;
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
