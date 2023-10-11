import React from 'react'
import StudentDashBoard from './StudentDashBoard'


function MyProfile() {
  return (
    <div>
    <nav><StudentDashBoard/></nav>
    <div className="profile-container">
  <div className="profile-card">
    <img src="https://cdn.imgbin.com/2/25/6/imgbin-avatar-user-profile-computer-icons-woman-avatar-Y5eDBdPkX58nqAUMNGFdUsUGc.jpg" alt="Person" className="card__image"/>
    <p className="card__name">Lily</p>
    <button className="btnpro draw-border">IT</button>
    <button className="btnpro draw-border">MY PROFILE</button>

  </div>
 
</div>

    </div>
  )
}

export default MyProfile