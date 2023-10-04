package com.example.thamarai.academicPerformance.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.thamarai.academicPerformance.Entity.StudentEntity;

import com.example.thamarai.academicPerformance.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/signupStudent")
	 public String singUp(@RequestBody StudentEntity student)
	  {
		   return studentService.saveSignUp(student);
		  
	  }
	@GetMapping("/getstudent/{emailid}")
	public Optional<StudentEntity> getStudentIn(@PathVariable String emailid)
	{
		return studentService.getStudent(emailid);
	}
	@GetMapping("/getAllstudent")
	public Iterable<StudentEntity> getStudent()
	{
		return studentService.read();
	}
	@PutMapping("/resetpasswordStudent")
	public void changePassword(@RequestBody StudentEntity student)
	{
		studentService.resetPassword(student);
	}
	@DeleteMapping("/deleteStudent/{emailid}")
	public void remove(@PathVariable String emailid)
	{
		studentService.deleteStudent(emailid);
	}
	

}
