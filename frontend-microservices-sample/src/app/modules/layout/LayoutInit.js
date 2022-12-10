import React from 'react'
import "./LayoutInit.css"
import AsideMenu from './components/Aside/AsideMenu'
import HeaderNav from './components/Header/HeaderNav'
import ModalPopUp from './components/Modals/ModalPopUp'

export function LayoutInit({ children }) {
    return (
        <div className="page d-flex flex-row flex-column-fluid">
            <AsideMenu />
            <div className="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper" >
                <HeaderNav />
                <div id="kt_content" className="content d-flex flex-column flex-column-fluid">
                    {children}
                </div>

                <div className="footer py-4 d-flex flex-lg-column" id="kt_footer">
                    <div className="container-xxl d-flex flex-column flex-md-row flex-stack">
                        <div className="text-dark order-2 order-md-1">
                            <span className="text-gray-400 fw-bold me-1">Created by</span>
                            <span className="text-muted text-hover-primary fw-bold me-2 fs-6">Febry D F</span>
                        </div>
                        <ul className="menu menu-gray-600 menu-hover-primary fw-bold order-1">
                            <li className="menu-item">
                                <span className="menu-link px-2">Email</span>
                            </li>
                            <li className="menu-item">
                                <span className="menu-link px-2">Instagram</span>
                            </li>
                            <li className="menu-item">
                                <span className="menu-link px-2">Whatsapp</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <ModalPopUp />
        </div>
    )
}
