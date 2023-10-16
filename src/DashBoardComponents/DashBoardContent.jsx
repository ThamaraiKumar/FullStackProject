import React from 'react'
import SideBar from '../Components/SideBar'
import './Home.css'

function DashBoardContent() {
  return (
    <div>
    <div><SideBar/></div>
    <div className='dash-board-content'>
    <h1>DASH BOARD-SKCT</h1>
    <div className='dashboard-content-card'>
    <div class="dasgb-card">
      <p class="dasgb-card-title">TOTAL NO OF DEPARTMENTS</p>
      <p class="small-desc">
       10
      </p>
      <div class="go-corner">
        <div class="go-arrow">→</div>
      </div>
    </div>
    </div>

    <div className='dashboard-content-card'>
    <div class="dasgb-card1">
      <p class="dasgb-card-title1">TOTAL NO OF <br/>STAFF</p>
      <p class="small-desc1">
       500
      </p>
      <div class="go-corner1">
        <div class="go-arrow1">→</div>
      </div>
    </div>
    </div>

    <div className='dashboard-content-card'>
    <div class="dasgb-card2">
      <p class="dasgb-card-title2">TOTAL NO OF <br/>STUDENTS</p>
      <p class="small-desc2">
       5000+
      </p>
      <div class="go-corner2">
        <div class="go-arrow2">→</div>
      </div>
    </div>
    </div>

    
  </div>
</div>
    
  )
}

export default DashBoardContent



// <div className="ag-courses_item">
//       <div className="ag-courses-item_link">
//         <div className="ag-courses-item_bg"></div>

//         <div className="ag-courses-item_title">
//           TOTAL NO OF STAFF<br/>500
//         </div>
//       </div>
//     </div>

//     <div className="ag-courses_item">
//       <div className="ag-courses-item_link">
//         <div className="ag-courses-item_bg"></div>

//         <div className="ag-courses-item_title">
//           TOTAL NO OF DEPARTMENTS<br/>10
//         </div>
//       </div>
//     </div>