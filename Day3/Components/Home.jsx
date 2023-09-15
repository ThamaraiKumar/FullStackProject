import React, { useState } from 'react'
import'./Home.css'
import './Login.css'
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';

function Home() {
    const[emailid,setEmailId]=useState("");
  const[password,setPassword]=useState("");
  const[name,setName]=useState("");
  const[gender,setGender]=useState("");
  const[age,setAge]=useState("");
  const[DOB,setDOB]=useState("");
  const nav=useNavigate();


  
  const authenticate=(event)=>{
    event.preventDefault();
 if(emailid.length===0|| password.length===0)
 {
 
  toast.error("Enter all fields");
 }
 
 else{
  toast.success("LoggedIn");
  nav("/")
 }}
  return (
    <div>
    <div className='heading'>
    <h1>Welcome!!!</h1>
    <div className='signcover'></div>
    <h2>ADD STAFF</h2>
    <form>


    
    <label htmlform="useremail" className='newuser'>Email Id</label><br/>
    <input type="email" placeholder='Email Id' onChange={(e) =>setEmailId(e.target.value)} value={emailid} className='in-put-users' required/>

    <label  htmlform="name" className='newName'>Name</label><br/>
    <input type="text" value={name} onChange={(e) =>setName(e.target.value)} placeholder='Name' className='in-put-name' required/>
   
    <label  htmlform="password" className='newpassword'>Password</label><br/>
    <input type="password" value={password} onChange={(e) =>setPassword(e.target.value)} placeholder='Password' className='in-put-passwords' required/>
    
    
    
    <label  htmlform="Age" className='newAge'>Age</label><br/>
    <input type="text" value={age} onChange={(e) =>setAge(e.target.value)} placeholder='Age' className='in-put-age' required/>
    
    
    <label  htmlform="gender" className='newGender'>Gender</label><br/>
    <input type="text" value={gender} onChange={(e) =>setGender(e.target.value)} placeholder='Gender' className='in-put-gender' required/>
    
    
    <label  htmlform="dob" className='newdob'>DOB</label><br/>
    <input type="text" value={DOB} onChange={(e) =>setDOB(e.target.value)} placeholder='DOB' className='in-put-dob' required/>

     <button type='submit'  onClick={authenticate} className='add-btn'>ADD</button>

     <ToastContainer/>
    </form>
    
   
    </div>
    </div>
  )
}

export default Home