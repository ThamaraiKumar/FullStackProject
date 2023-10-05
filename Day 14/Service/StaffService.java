package com.example.thamarai.EvaluationofAP.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thamarai.EvaluationofAP.Entity.StaffEntity;

import com.example.thamarai.EvaluationofAP.Repository.StaffRepository;

@Service
public class StaffService {
	
	@Autowired
	StaffRepository staffRepo;
	
	 public String saveSignUp(StaffEntity staff)
	  {
		  staffRepo.save(staff);
		  return "Thanks for signUp";
	  }
	 
	 public Optional<StaffEntity> getStaff(String emailid)
		{
			return staffRepo.findById(emailid);
		}
	 public Iterable<StaffEntity> read()
	 {
		 return staffRepo.findAll();
	 }
	 public void resetPassword(StaffEntity staff)
		{
			staffRepo.save(staff);
			System.out.println("Password Changed Successfully");
		}
	 public void deleteStaff(String emailid)
	 {
		 staffRepo.deleteById(emailid);
	 }

}
