import React from 'react'
import StaffSideBar from './StaffSideBar'

function Attendance() {
    const data=[
        { name: "Manisha", year: 3, gender: "Female", Emailid: "2018meb1236@gmail.com",department:"IT",att:'P' },
  { name: "Tanishq", year: 3, gender: "Male", Emailid: "2018eeb1190@gmail.com",department:"IT" ,att:'P'},
  { name: "Stark", year: 3, gender: "Female", Emailid: "2019csb1212@gmail.com",department:"IT",att:'P' },
  {  name:'arun',gender:'Male',year:3,Emailid:'2018it1234@gmail.com',department:'IT',att:'P'},
    {  name:'rajesh',gender:'Male',year:3,Emailid:'2016it36@gmail.com',department:'IT',att:'A'},
 {  
    name:'moorthy',gender:'Male',year:3,Emailid:'2019457it@gmail.com',department:'IT',att:'P'},
 {  
    name:'raja',gender:'Male',year:3,Emailid:'2027it464@gmail.com',department:'IT',att:'P'},
 {  
    name:'usha',gender:'Female',year:3,Emailid:'2018it456@gmail.com',department:'IT',att:'P'},
 {  
    name:'priya',gender:'Female',year:3,Emailid:'2018it34@gmail.com',department:'IT',att:'P'},
 {  
    name:'Sundar',gender:'Male',year:3,Emailid:'2018it789@gmail.com',department:'IT',att:'P'
 },
 {name:'Kavya',gender:'Female',year:3,Emailid:'2018it800@gmail.com',department:'IT',att:'P'},
 {name:'Dinesh',gender:'Male',year:3,Emailid:'2018it456@gmail.com',department:'IT',att:'P'},
    ]
  return (
    <div>
    
    <nav><StaffSideBar/></nav>
    <div>
    <div className='student-details-in-staff'>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Year</th>
            <th>Gender</th>
            <th>Email Id</th>
            <th>Department</th>
            <th>Attendance</th>
          </tr>
        </thead>
        <tbody>
          {data.map((value, key) => {
            return (
              <tr key={key}>
                <td>{value.name}</td>
                <td>{value.year}</td>
                <td>{value.gender}</td>
                <td>{value.Emailid}</td>
                <td>{value.department}</td>
                <td>{value.att}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
      </div>
    </div>
    </div>
  )
}

export default Attendance