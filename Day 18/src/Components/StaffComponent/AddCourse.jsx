import React, { useState } from 'react'
import './StaffComponents.css'
import StaffSideBar from './StaffSideBar'

import { ToastContainer } from 'react-toastify';

function AddCourse() {
 

  const[coursecode,setCourseCode]=useState("");
  const[coursename,setCourseName]=useState("");

  const addCourse=(event)=>{
    event.preventDefault();
    const details={coursecode,coursename}
 if(coursecode.length===0|| coursename.length===0)
 {
 
  toast.error("Enter all fields");

 }
 else{
  fetch("http://localhost:8080/course/staff/addCourse",{
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(details)
  }
  ).then(()=>{
    console.log("New Detail Added");   
    console.log(JSON.stringify(details));
    console.log(e);
    nav("/viewcourse")
  })  
 }
}
 

  return (
    <div><div><StaffSideBar/></div>
    <div class="form-container">
      <form class="form">
        <div class="form-group">
          <label for="courseId">Course Id</label>
          <input type="text" id="courseid" value={coursecode} onChange={(e) =>setCourseCode(e.target.value)} name="coursecode" required=""/>
        </div>
        <div class="form-group">
          <label for="courseName">Course Name</label>
          <input name="coursename" id="courseName" value={coursename} onChange={(e) =>setCourseName(e.target.value)} type='text' required=""/>
        </div>
        <button class="form-submit-btn" onClick={addCourse} type="submit">Submit</button>
        <ToastContainer/>
      </form>
    </div>
    
    </div>
  )
}

export default AddCourse