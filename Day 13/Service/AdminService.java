package com.example.thamarai.academicPerformance.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.thamarai.academicPerformance.Entity.AdminEntity;

import com.example.thamarai.academicPerformance.Repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepo;
	
	 public String saveSignUp(AdminEntity admin)
	  {
		  adminRepo.save(admin);
		  return "Thanks for signUp";
	  }
	 
	 public Optional<AdminEntity> getAdmin(String emailid)
		{
			return adminRepo.findById(emailid);
		}
	 public void change(AdminEntity admin)
		{
			adminRepo.save(admin);
			System.out.println("Password Changed Successfully");
		}
	 public void delete()
		{
			adminRepo.deleteAll();
		}

	 public Iterable<AdminEntity>getAdmins()
	 {
		 return adminRepo.findAll();
	 }
}
