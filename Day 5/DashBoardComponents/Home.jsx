import React from 'react'
import { useDispatch, useSelector } from "react-redux";
import { logout, selectUser } from "../Redux/UserSlice";
import Person4 from '@mui/icons-material/Person4';


function Home() {
    

  const user = useSelector(selectUser);
  const dispatch = useDispatch();

  const username = user ? user.username : "Guest";
  const handleLogout = () => {
    dispatch(logout());
  };
  return (
    <div>
    <h1><Person4/>{username}</h1>
    <button onClick={handleLogout}>Logout</button>
    </div>
  )
}

export default Home