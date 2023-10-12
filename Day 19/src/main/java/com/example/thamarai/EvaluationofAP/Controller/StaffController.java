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

import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;
import com.example.thamarai.EvaluationofAP.Entity.StaffEntity;
import com.example.thamarai.EvaluationofAP.Exception.UserNotFoundException;
import com.example.thamarai.EvaluationofAP.Jwt.JwtGeneratorInterface;
import com.example.thamarai.EvaluationofAP.Service.StaffService;
import com.example.thamarai.EvaluationofAP.Service.UserService;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {
	 
	
	@Autowired
	StaffService staffService;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	 
	 private UserService userService;
	 private  JwtGeneratorInterface jwtGenerator;
	   @Autowired
	   public StaffController(UserService userService, JwtGeneratorInterface jwtGenerator){
	     this.userService=userService;
	     this.jwtGenerator=jwtGenerator;
	   }
	
	
	@PostMapping("/signupStaff")
	 public String singUp(@RequestBody StaffEntity staff)
	  {
		   return staffService.saveSignUp(staff);
		  
	  }
	@GetMapping("/getstaff/{emailid}")
	public Optional<StaffEntity> getStaffIn(@PathVariable String emailid)
	{
		return staffService.getStaff(emailid);
	}
	
	
	@GetMapping("/getAllstaff")
	public Iterable<StaffEntity> getStaff()
	{
		return staffService.read();
	}
	
	@PutMapping("/resetpasswordStaff")
	public void changePassword(@RequestBody StaffEntity staff)
	{
		staffService.resetPassword(staff);
	}
	@DeleteMapping("/deleteStaff/{emailid}")
	public void remove(@PathVariable String emailid)
	{
		staffService.deleteStaff(emailid);
	}
	
	
	 @PostMapping("/register")
	    public ResponseEntity<?> postUser(@RequestBody StaffEntity staff){
		 String password=staff.getPassword();
		 String hashedPassword=passwordEncoder.encode(password);
	        try{
	        	staff.setPassword(hashedPassword);
	            userService.saveUser(staff);
	            return new ResponseEntity<>(staff, HttpStatus.CREATED);
	        } catch (Exception e){
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	        }
	    }
	
	 @PostMapping("/login")
	  public ResponseEntity<?> loginUser(@RequestBody AdminEntity user) {
	    try {
	      if(user.getEmailid() == null || user.getPassword() == null) {
	      throw new UserNotFoundException("UserName or Password is Empty");
	    }
	      
	    AdminEntity userData = userService.getEmailidAndPassword(user.getEmailid(), user.getPassword());
	    if(userData == null){
	       throw new UserNotFoundException("UserName or Password is Invalid");
	    }
	       return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
	    } catch (UserNotFoundException e) {
	       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	    }
	  }
	
	
}
