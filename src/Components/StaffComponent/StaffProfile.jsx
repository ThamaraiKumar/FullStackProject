import React, { useEffect, useState } from 'react'
import './StaffComponents.css'
import StaffDashboard from './StaffDashboard'
import axios from 'axios';



function StaffProfile() {

    const username = localStorage.getItem('emailid');
    const[profile,setProfile]=useState([])
    const [details, setDetails] = useState([])

    // useEffect(()=>{
    //     fetch(`http://localhost:2001/staff/getstaff/${username}`)
    //         .then((response) => response.json())
    //         .then((data) => setProfile(data))
    //         .catch((error)=>{console.error('Error in profile fetching',error)});
    
    // },[username]);

    useEffect(() => {
        axios.get(`http://localhost:2001/staff/getstaff/${username}`)
            .then((response) => {
                setDetails(response.data);
            })
    }, [])


  return (
    <div>
    <nav><StaffDashboard/></nav>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.0.45/css/materialdesignicons.min.css" integrity="sha256-nRyVCcVDSlWN9d68r9M+rKBLE4k9Cp1j3XSY/umjvvU=" crossorigin="anonymous" />
<div className="container">
        <div className="col-md-6">
            <div className="card-profile m-b-30">
                <div className="card-header bg-white">
                    <h5 className="card-title text-black mb-0">My Profile</h5>
                </div>
                <div className="card-body">
                    <div className="xp-social-profile">
                        <div className="xp-social-profile-img">
                        </div>
                        <div className="xp-social-profile-top">
                            <div className="row">
                                <div className="col-6">
                                    <div className="xp-social-profile-avatar text-center">
                                        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="user-profile" className="rounded-circle img-fluid"/>
                                        <span className="xp-social-profile-live">  </span>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                        <div className="xp-social-profile-middle text-center">

                        
                             <div className="row">
                             {Array.isArray(profile) && profile.length > 0 ? (
                                profile.map((data) => (
                                    <div className="col-12" key={data.emailid}>
                                        <div className="xp-social-profile-title">
                                            <h5 className="my-1 text-black">{username}</h5>
                                        </div>
                                        <div className="xp-social-profile-subtitle">
                                            <p className="mb-3 text-muted">{data.seniority}</p>
                                        </div>
                                        <div className="xp-social-profile-desc">
                                            <p className="text-muted">{data.department}</p>
                                        </div>
                                    </div>
                                ))
                            ) : (
                                <p>No profile data available</p>
                            )}
                            </div>
                        </div> 
                        </div>
                        
                        </div>
                    </div>
                </div>
                <div><button className='update-button'>UPDATE</button></div>
            </div>
        </div>
   

  )
}

export default StaffProfile