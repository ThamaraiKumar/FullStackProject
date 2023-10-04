package com.example.thamarai.academicPerformance.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thamarai.academicPerformance.Entity.AdminEntity;
import com.example.thamarai.academicPerformance.Service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
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
	
	@Operation(summary = "logout")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "logout successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="not found")})
	@org.springframework.web.bind.annotation.DeleteMapping("/deleteAdmin")
	public void delete()
	{
		adminService.delete();
	}

}
