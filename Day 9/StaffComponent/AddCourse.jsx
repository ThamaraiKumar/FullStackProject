import React from 'react'
import './StaffComponents.css'
import StaffSideBar from './StaffSideBar'
import { Link } from 'react-router-dom'

function AddCourse() {
  return (
    <div><div><StaffSideBar/></div>
    <div class="form-container">
      <form class="form">
        <div class="form-group">
          <label for="courseId">Course Id</label>
          <input type="courseid" id="courseid" name="courseid" required=""/>
        </div>
        <div class="form-group">
          <label for="courseName">Course Name</label>
          <input name="coursename" id="courseName" type='text' required=""/>
        </div>
        <Link to="/viewcourse" style={{textDecoration:'none'}}><button class="form-submit-btn" type="submit">Submit</button></Link>
      </form>
    </div>
    
    </div>
  )
}

export default AddCourse