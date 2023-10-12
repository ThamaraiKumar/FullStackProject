package com.example.thamarai.EvaluationofAP.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thamarai.EvaluationofAP.Entity.StudentEntity;
import com.example.thamarai.EvaluationofAP.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	 public String saveSignUp(StudentEntity student)   //register student
	  {
		 studentRepo.save(student);
		  return "Thanks for signUp";
	  }
	 
	 public Optional<StudentEntity> getStudent(String emailid) //login of student and also get particular student
		{
			return studentRepo.findById(emailid);
		}
	 public Iterable<StudentEntity> read()   //get all student details
	 {
		 return studentRepo.findAll();
	 }
	 public void resetPassword(StudentEntity student) //reset password
		{
			studentRepo.save(student);
			System.out.println("Password Changed Successfully");
		}
	 public void deleteStudent(String emailid)   //remove student
	 {
		 studentRepo.deleteById(emailid);
	 }


}
