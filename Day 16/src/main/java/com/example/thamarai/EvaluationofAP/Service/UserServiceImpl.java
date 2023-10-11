package com.example.thamarai.EvaluationofAP.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;
import com.example.thamarai.EvaluationofAP.Exception.UserNotFoundException;
import com.example.thamarai.EvaluationofAP.Repository.AdminRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private AdminRepository adminRepository;
	  @Autowired
	  public UserServiceImpl(AdminRepository adminRepository){
	    this.adminRepository=adminRepository;
	  }
	  @Override
	  public void saveUser(AdminEntity admin) {
	    adminRepository.save(admin);
	  }
	  @Override
	  public AdminEntity getEmailidAndPassword(String name, String plainPassword) throws UserNotFoundException {
	    AdminEntity user = adminRepository.findByEmailid(name);
	    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	    String hashedPassword=user.getPassword();
	    boolean exists=passwordEncoder.matches(plainPassword,hashedPassword);
	    if(exists)
	    {
	    	return user;
	    }
	    else
	    {
	    	throw new UserNotFoundException("Invalid id and password");
	    }
	    
	    
	    
//	    if(user == null){
//	       throw new UserNotFoundException("Invalid id and password");
//	    }
//	    return user;
	   // BCryptPasswordEncoder passwordEncoder;
	   // boolean exists=passwordEncoder.matches(hashedPassword, plainPassword);
	  }

}
