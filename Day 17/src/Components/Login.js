import React, { useState } from 'react'
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import './Login.css'
import NavBar from './NavBar';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from "react-redux";
import { login } from "../Redux/UserSlice";


function Login() {
  
  const nav=useNavigate();
  const dispatch = useDispatch();



  const handleChange = (e) => {
    setFormdata({ ...formdata, [e.target.name]: e.target.value });
    console.log(formdata);
  };
  const [formdata, setFormdata] = useState({
    username: "",
    password: "",
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    
    if(formdata.username.length===0 || formdata.password.length===0)
  {
    toast.error("Enter all fields");
  }
 else if(formdata.username!=="Thamarai@gmail.com" && formdata.password!=="ThamaraiAdmin")
 {
  toast.warning("Invalid Admin Entry");
 }
 else{
  toast.success("LoggedIn");
  nav("/home");
 }
    dispatch(
      login({
        username: formdata.username,
      })
    );
  };

  return (
    <div>
    <div className='login'>
    <NavBar/>
    <div className='auth-form-container'>
    <div id="cover"></div>
    <form id="formContent">
    <h2>Login Page</h2><br/>


    
    <label htmlform="useremail" className='Aloginuser'>Admin Email Id</label><br/>
    <input type="email" name='username' placeholder='Email Id' value={formdata.username}
    onChange={handleChange} className='in-put-user' required/>

    <label  htmlform="password" className='loginpassword'>Password</label><br/>
    <input type="password" name='password' value={formdata.password}
    onChange={handleChange} placeholder='Password' className='in-put-password' required/>

    <button type='submit' onClick={handleSubmit} className='login-btn'>LOGIN</button>
    <ToastContainer autoClose={1000}/>

    </form>
    
    </div>
    </div>

    </div>
  );
}

export default Login;




  


  
//   const authenticate=(event)=>{
//     event.preventDefault();
//  if(emailid.length===0|| password.length===0)
//  {
 
//   toast.error("Enter all fields");

//  }
//  else if(emailid!=="Thamarai@gmail.com" && password!=="ThamaraiAdmin")
//  {
//   toast.warning("Invalid Admin Entry");
//  }
//  else{
//   toast.success("LoggedIn");
//   nav("/home");
//  }
 
// }
// const[emailid,setEmailId]=useState("");
//   const[password,setPassword]=useState("");