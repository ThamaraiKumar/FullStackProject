import React, { useState } from 'react'
import { toast, ToastContainer } from "react-toastify";
import './Login.css'
import { useNavigate } from 'react-router-dom';


function StaffLogin() {
    const[emailid,setEmailId]=useState("");
  const[password,setPassword]=useState("");
  
  const nav=useNavigate();

  
  const authenticate=(event)=>{
    event.preventDefault();
 if(emailid.length===0|| password.length===0)
 {
 
  toast.error("Enter all fields");

 }
 else{
    toast.success("Logged In");
    navigator("/home");
 }
 
}
  return (
    <div className='staff-login'>
    <div className='login-as-staff'><h2>Login As Staff</h2></div>
    <form>
    <div className='pagescover'></div>
    <label htmlform="useremail" className='loginuser'>Admin Email Id</label><br/>
    <input type="email" placeholder='Email Id' onChange={(e) =>setEmailId(e.target.value)} value={emailid} className='in-put-user' required/>

    <label  htmlform="password" className='loginpassword'>Password</label><br/>
    <input type="password" value={password} onChange={(e) =>setPassword(e.target.value)} placeholder='Password' className='in-put-password' required/>

     <button type='submit'  onClick={authenticate} className='login-btn'>LOGIN</button>

     <ToastContainer/>
    </form>
    <button className='btn'>Don't have an Account ? REGISTER HERE</button>
    
    </div>
  )
}

export default StaffLogin