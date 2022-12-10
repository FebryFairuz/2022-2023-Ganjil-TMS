import React from 'react'
import IMG_ERROR from "../../../../_metronic/_assets/media/illustrations/18-dark.png"

export function ErrorTemp() {
  return (
    <div id="kt_content_container" className='max-screen bg-white m-auto'>
      <div className='d-flex flex-column flex-center flex-column-fluid p-10 mt-20'>
        <img src={IMG_ERROR} alt="Error 404" className='mw-100 mb-10' />
        <h1 className='fw-bold mb-10'>Seems there is nothing here</h1>
      </div>
    </div>
  )
}
