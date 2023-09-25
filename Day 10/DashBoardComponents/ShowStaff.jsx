import React from 'react'
import './Home.css'
import SideBar from '../Components/SideBar'


function ShowStaff() {
  return (
    <div>
    <div><SideBar/></div>
    <grid className='grid-table'>
    <table className='rwd-table'>
      <thead>
        <tr>
          <th>STAFF ID</th>
          <th>EMAIL ID</th>
          <th>NAME</th>
          <th>DEPARTMENT</th>
          <th>YEAR OF EXPERIENCE</th>
          <th>AGE</th>
        </tr>
      </thead>
      <tbody><tr>
      <td>727821TUIT</td>
      <td>727821tuit@skct.edu.in</td>
      <td>THAMARAI</td>
      <td>INFORMATION TECHNOLOGY</td>
      <td>3</td>
      <td>20</td>
      </tr>
      </tbody>
    </table>
    </grid>
    </div>
  )
}

export default ShowStaff