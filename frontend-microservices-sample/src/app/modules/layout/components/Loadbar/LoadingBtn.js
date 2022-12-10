import React from 'react'

export default function LoadingBtn() {
    return (
        <div className="text-center m-3">
            <div className="spinner-border text-info" role="status">
                <span className="visually-hidden">Loading...</span>
            </div>
        </div>
    )
}
