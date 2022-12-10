import React from 'react'
import { Students,Filter } from './widgets'

export function Home() {
  return (
    <div id="kt_content_container" className='container-xxl'>
      <div className="row g-5 g-xl-8">
        <div className="col-xxl-8">
            <Students />
        </div>
        <div className="col-xxl-4">
            <Filter />
        </div>
      </div>

      
    </div>
  )
}
