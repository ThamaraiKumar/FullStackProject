import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import StaffSideBar from './StaffSideBar';

function AddStudent() {
    const[emailid,setEmailId]=useState("");
    const[password,setPassword]=useState("");
    const[name,setName]=useState("");
    const[department,setDepartment]=useState("");
    const[gender,setGender]=useState("");
    const[year,setyos]=useState("");
    const[rollno,setRollno]=useState("");
    const nav=useNavigate();
    const authenticate=(event)=>{
      event.preventDefault();
      const details={emailid,password,name,department,gender,year,rollno};
   if(emailid.length===0|| password.length===0)
   {
   
    toast.error("Enter all fields");
   }
   
   else{
    fetch("http://localhost:8080/student/register",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(details)
    }
    ).then(()=>{
      console.log("New Detail Added");   
      console.log(JSON.stringify(details));
      console.log(event);
      toast.success("LoggedIn");
    nav("/")
    })
   }
   }
  return (
    <div>
    
     <div>
      <div className='sidebarinallpage'><StaffSideBar/></div>
      <div className='heading'>
      <div className='signcover'></div>
      <h2 className='register-form' style={{color:'black'}}>ADD STUDENT</h2>
      <form>
      <label htmlform="useremail" className='newuser'>Email Id</label><br/>
      <input type="email" placeholder='Email Id' onChange={(e) =>setEmailId(e.target.value)} value={emailid} className='in-put-users' required/>
  
      <label  htmlform="name" className='newName'>Name</label><br/>
      <input type="text" value={name} onChange={(e) =>setName(e.target.value)} placeholder='Name' className='in-put-name' required/>
     
      <label  htmlform="password" className='newpassword'>Password</label><br/>
      <input type="password" value={password} onChange={(e) =>setPassword(e.target.value)} placeholder='Password' className='in-put-passwords' required/>
      
      
      
      <label  htmlform="Age" className='newAge'>Gender</label><br/>
      <input type="text" value={gender} onChange={(e) =>setGender(e.target.value)} placeholder='F/M' className='in-put-age' required/>
      
      
      <label  htmlform="gender" className='newGender'>Department</label><br/>
      <input type="text" value={department} onChange={(e) =>setDepartment(e.target.value)} placeholder='Department' className='in-put-gender' required/>
      
      
      <label  htmlform="dob" className='newdob'>Year</label><br/>
      <input type="text" value={year} onChange={(e) =>setyos(e.target.value)} placeholder='year of study' className='in-put-dob' required/>
      
      <label  htmlform="rollno" className='newroll'>Rollno</label><br/>
      <input type="text" value={rollno} onChange={(e) =>setRollno(e.target.value)} placeholder='roll number' className='in-put-rollno' required/>
      
      <button type='submit'  onClick={authenticate} className='add-btn'>ADD</button>
       <ToastContainer/>
      </form>
     </div>
    </div>
    </div>
  )
}

export default AddStudent