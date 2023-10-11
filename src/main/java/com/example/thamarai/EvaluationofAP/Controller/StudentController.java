package com.example.thamarai.EvaluationofAP.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thamarai.EvaluationofAP.Entity.StudentEntity;
import com.example.thamarai.EvaluationofAP.Service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/signupStudent")
	 public String singUp(@RequestBody StudentEntity student)
	  {
		   return studentService.saveSignUp(student);
		  
	  }
	
	@PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody StudentEntity student){
		String password=student.getPassword();
	    String hashedPassword=passwordEncoder.encode(password);
        try{
        	student.setPassword(hashedPassword);
            studentService.saveSignUp(student);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
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
