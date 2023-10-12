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
	 
	 
//	 public AdminEntity getUserByNameAndPassword(String emailid, String password) throws UserNotFoundException {
//		 AdminEntity user = adminRepo.findByEmailid(emailid);
//		    if(user == null){
//		       throw new UserNotFoundException("Invalid id and password");
//		    }
//		    return user;
//		  }
	 public void saveAdmin(AdminEntity admin) {
	        adminRepo.save(admin);
	    }

}
