import React from "react";
import { Link } from "react-router-dom";
import Logo from "../../../../../_metronic/_assets/media/logos/logo-ibik-white.jpeg";

export default function AsideMenu() {
  return (
    <div
      id="kt_aside"
      className="aside bg-primary"
      data-kt-drawer="true"
      data-kt-drawer-name="aside"
      data-kt-drawer-activate="{default: true, lg: false}"
      data-kt-drawer-overlay="true"
      data-kt-drawer-width="auto"
      data-kt-drawer-direction="start"
      data-kt-drawer-toggle="#kt_aside_toggle"
    >
      <div
        className="aside-logo d-none d-lg-flex flex-column align-items-center flex-column-auto py-8"
        id="kt_aside_logo"
      >
        <a>
          <img alt="Logo" src={Logo} className="h-55px rounded" />
        </a>
      </div>
      <div
        className="aside-nav d-flex flex-column align-lg-center flex-column-fluid w-100 pt-5 pt-lg-0"
        id="kt_aside_nav"
      >
        <div
          id="kt_aside_menu"
          className="menu menu-column menu-title-gray-600 menu-state-primary menu-state-icon-primary menu-state-bullet-primary menu-arrow-gray-500 fw-bold fs-6"
          data-kt-menu="true"
        >
          <div
            data-kt-menu-trigger="click"
            data-kt-menu-placement="right-start"
            className="menu-item here show py-3"
          >
            <Link
              to="/home"
              className="menu-link menu-center"
              title="Students"
            >
                <span className="menu-icon me-0">
                  <i className="bi bi-people fs-2"></i>
                </span>
            </Link>
          </div>
        </div>
      </div>
      <div
        className="aside-footer d-flex flex-column align-items-center flex-column-auto"
        id="kt_aside_footer"
      >
        <div className="mb-7">
          <Link
            to="/signout"
            className="btn btm-sm btn-icon btn-color-white btn-active-color-primary btn-active-light"
            title="Sign Out"
          >
            <span className="svg-icon svg-icon-2 svg-icon-lg-1">
              <svg
                width="16"
                height="16"
                fill="currentColor"
                className="bi bi-power"
                viewBox="0 0 16 16"
              >
                <path d="M7.5 1v7h1V1h-1z" />
                <path d="M3 8.812a4.999 4.999 0 0 1 2.578-4.375l-.485-.874A6 6 0 1 0 11 3.616l-.501.865A5 5 0 1 1 3 8.812z" />
              </svg>
            </span>
          </Link>
        </div>
      </div>
    </div>
  );
}
