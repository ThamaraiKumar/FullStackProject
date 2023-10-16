import React from 'react'
import './Home.css'
import SideBar from '../Components/SideBar'
import { useEffect } from 'react'
import axios from 'axios'
import { useState } from 'react'


function ShowStaff() {
  const [details, setDetails] = useState([])
     
    
  useEffect(() => {
      axios.get("http://localhost:8080/staff/staffdetails")
          .then((response) => {
              setDetails(response.data);
          })
  }, [])

  return (
    <div>
    <div><SideBar/></div>
    <div className='staffdetails-heading'>STAFF DETAILS</div>
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
      <tbody>

      {details.map((staff) =>{return (
        <tr>
        <td>{staff.bookId}</td>
        <td>{staff.userinfo}</td>
        <td>{staff.bookName}</td>
        <td>{staff.authorName}</td>
        <td>{staff.bookVolume}</td>
        <td>{staff.price}</td>
        <td>{staff.category}</td>
        <td>{staff.imageurl}</td>
        </tr> )})}
      </tbody>
    </table>
    </grid>
    </div>
  )
}

export default ShowStaff