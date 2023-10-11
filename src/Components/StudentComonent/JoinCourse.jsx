import React from 'react'
import '../StaffComponent/StaffComponents.css'
import { Link } from 'react-router-dom'
import StudentSideBar from './StudentSideBar'

function JoinCourse() {
  return (
    <div><div><StudentSideBar/></div>
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
        <Link to="/student/viewcourse" style={{textDecoration:'none'}}><button class="form-submit-btn" type="submit">JOIN</button></Link>
      </form>
    </div>
    
    </div>
  )
}

export default JoinCourse