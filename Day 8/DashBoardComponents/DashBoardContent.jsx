import React from 'react'
import SideBar from '../Components/SideBar'
import './Home.css'

function DashBoardContent() {
  return (
    <div>
    <div><SideBar/></div>
    <div classNameName='dash-board-content'>
    <h1>DashBoardContent</h1>
    <div>
    <div className="ag-format-container">
  <div className="ag-courses_box">

    <div className="ag-courses_item">
      <div className="ag-courses-item_link">
        <div className="ag-courses-item_bg"></div>

        <div className="ag-courses-item_title">
          TOTAL NO OF STUDENTS<br/>4000
        </div>
      </div>
    </div>

    <div className="ag-courses_item">
      <div className="ag-courses-item_link">
        <div className="ag-courses-item_bg"></div>

        <div className="ag-courses-item_title">
          TOTAL NO OF STAFF<br/>500
        </div>
      </div>
    </div>

    <div className="ag-courses_item">
      <div className="ag-courses-item_link">
        <div className="ag-courses-item_bg"></div>

        <div className="ag-courses-item_title">
          TOTAL NO OF DEPARTMENTS<br/>10
        </div>
      </div>
    </div>
  </div>
</div>
    </div>
    </div>
    </div>
  )
}

export default DashBoardContent