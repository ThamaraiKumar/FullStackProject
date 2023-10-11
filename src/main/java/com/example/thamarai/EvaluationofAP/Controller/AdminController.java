package com.example.thamarai.EvaluationofAP.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;
import com.example.thamarai.EvaluationofAP.Exception.UserNotFoundException;
import com.example.thamarai.EvaluationofAP.Jwt.JwtGeneratorInterface;
import com.example.thamarai.EvaluationofAP.Service.AdminService;
import com.example.thamarai.EvaluationofAP.Service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
    AdminService adminService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	 
	 private UserService userService;
	 private  JwtGeneratorInterface jwtGenerator;
	   @Autowired
	   public AdminController(UserService userService, JwtGeneratorInterface jwtGenerator){
	     this.userService=userService;
	     this.jwtGenerator=jwtGenerator;
	   }
	
	
	
	@PostMapping("/signupAdmin")
	 public String singUp(@RequestBody AdminEntity admin)
	  {
		   return adminService.saveSignUp(admin);
	  }
	@GetMapping("/getAdmin/{emailid}")
	public Optional<AdminEntity> getAdminIn(@PathVariable String emailid)
	{
		return adminService.getAdmin(emailid);
	}
	@PutMapping("/updateAdmin")
	public void changePassword(@RequestBody AdminEntity admin)
	{
		adminService.change(admin);
	}
	
	@GetMapping("/getAllAdmin")
	public Iterable<AdminEntity> getAdmins()
	{
		return adminService.getAdmins();
	}
	
	@Operation(summary = "logout")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "logout successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="not found")})
	@org.springframework.web.bind.annotation.DeleteMapping("/deleteAdmin")
	public void delete()
	{
		adminService.delete();
	}

	
	
	
	 @PostMapping("/register")
	    public ResponseEntity<?> postUser(@RequestBody AdminEntity admin){
		 String password=admin.getPassword();
		 String hashedPassword=passwordEncoder.encode(password);
	        try{
	        	admin.setPassword(hashedPassword);
	            userService.saveUser(admin);
	            return new ResponseEntity<>(admin, HttpStatus.CREATED);
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
	
	
	
	
	
	@GetMapping("/unrestricted")
    public ResponseEntity<?> getMessage() {
    return new ResponseEntity<>("Hai this is a normal message..", HttpStatus.OK);
}
@GetMapping("/restricted")
public ResponseEntity<?> getRestrictedMessage() {
    return new ResponseEntity<>("This is a restricted message", HttpStatus.OK);
}
}
