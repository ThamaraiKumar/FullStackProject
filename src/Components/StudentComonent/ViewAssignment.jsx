import React from 'react'
import './StudentComponent.css'
import StudentCourseBar from './StudentCourseBar'
import { Link } from 'react-router-dom'

function ViewAssignment() {
  return (
    <div>
    <nav><StudentCourseBar/></nav>
    <h1>ASSIGNMENT</h1>
    <form id="file-upload-form" class="uploader">
    <input id="file-upload" type="file" name="fileUpload" accept="image/*" />
  
    <label for="file-upload" id="file-drag">
      <img id="file-image" src="#" alt="Preview" class="hidden"/>
      <div id="file-start">
        <i class="fa fa-download" aria-hidden="true"></i>
        <div>Select a file to upload</div>
        <div id="notimage" class="hidden">Please select an image</div>
        <span id="file-upload-btn" class="btn btn-primary">Select a file</span>
      </div>
      <div id="response" class="hidden">
        <div id="messages"></div>
        <progress class="progress" id="file-progress" value="0">
          <span>0</span>%
        </progress>
      </div>
    </label>
    <Link to="/student/viewcourse" style={{textDecoration:'none',color:'inherit'}}><button type='submit' className='btn submit-assginment'>Submit</button></Link>
    </form>
    </div>
  )
}

export default ViewAssignment