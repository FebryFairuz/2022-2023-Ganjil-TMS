import React from "react";
import { useDispatch } from 'react-redux';
import { Routes, Route, Navigate } from "react-router-dom";
import PublicRoute from "./PublicRoute";
import PrivateRoute from "./PrivateRoute";
import { LayoutInit } from "./modules/layout";
import { ErrorTemp } from "./modules/pages";

export default function Routed() {
    const isAuthorized = localStorage.getItem("AuthToken");
    const dispatch = useDispatch();

    const SignOUT = () => {
        dispatch({ type: "SIGN_OUT" });
        return (
            <Routes>
                <Navigate to='/login' />
            </Routes>
        )
    };

    const SigninPage = () =>{
        return <h3>signin page</h3>;
    }

    
    return (
        <Routes>
            <Route path="/error/*" element={<LayoutInit><ErrorTemp /></LayoutInit>} />
            <Route path="/signout" element={<SignOUT />} />
            {(isAuthorized) ? (
                <>
                    <Route path="/*" element={<PrivateRoute />} />
                </>
            ) : (
                <>
                    <Route path='/signin' element={<SigninPage />} />
                    <Route path='/*' element={<PublicRoute />} />
                </>
            )}


            <Route path='*' element={<Navigate to='/error' />} />
        </Routes>
    )
}
