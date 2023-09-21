import React, { useState } from 'react'
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import './Login.css'
import NavBar from './NavBar';
import Footer from './Footer';
import { useNavigate } from 'react-router-dom';



function Login() {
  const[emailid,setEmailId]=useState("");
  const[password,setPassword]=useState("");
  const nav=useNavigate();


  
  const authenticate=(event)=>{
    event.preventDefault();
 if(emailid.length===0|| password.length===0)
 {
 
  toast.error("Enter all fields");

 }
 else if(emailid!=="Thamarai@gmail.com" && password!=="ThamaraiAdmin")
 {
  toast.warning("Invalid Admin Entry");
 }
 else{
  toast.success("LoggedIn");
  nav("/home");
 }
 
}
  return (
    <div>
    <div className='login'>
    <NavBar/>
    <div className='auth-form-container'>
    <div id="cover"></div>
    <form id="formContent">
    <h2>Login Page</h2><br/>


    
    <label htmlform="useremail" className='loginuser'>Admin Email Id</label><br/>
    <input type="email" placeholder='Email Id' onChange={(e) =>setEmailId(e.target.value)} value={emailid} className='in-put-user' required/>

    <label  htmlform="password" className='loginpassword'>Password</label><br/>
    <input type="password" value={password} onChange={(e) =>setPassword(e.target.value)} placeholder='Password' className='in-put-password' required/>

     <button type='submit'  onClick={authenticate} className='login-btn'>LOGIN</button>

     <ToastContainer/>
    </form>
    
    </div>
    </div>
    <Footer/>

    </div>
  );
}

export default Login;