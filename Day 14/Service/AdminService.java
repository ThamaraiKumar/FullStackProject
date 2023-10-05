package com.example.thamarai.EvaluationofAP.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;

import com.example.thamarai.EvaluationofAP.Repository.AdminRepository;

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
	 
	 
//	 public AdminEntity getUserByNameAndPassword(String emailid, String password)  {
//		    AdminEntity user = adminRepo.findByUserNameAndPassword(emailid, password);
//		    if(user == null){
//		      System.out.println("Invalid id and password");
//		    }
//		    return user;
//		  }
}
