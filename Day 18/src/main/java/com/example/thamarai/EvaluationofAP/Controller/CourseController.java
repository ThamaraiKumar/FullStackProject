package com.example.thamarai.EvaluationofAP.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thamarai.EvaluationofAP.Entity.CourseEntity;
import com.example.thamarai.EvaluationofAP.Service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/staff/addCourse")
	 public String singUp(@RequestBody CourseEntity course)
	  {
		   return courseService.postCourse(course);
	  }
	@GetMapping("/student/getCourse/{courseid}")
	public Optional<CourseEntity> getAdminIn(@PathVariable int courseid)
	{
		return courseService.getCourse(courseid);
	}
	@PutMapping("/updateCourse")
	public void updateCourse(@RequestBody CourseEntity course)
	{
		courseService.change(course);
	}
	
	@GetMapping("/getAllCourse")
	public Iterable<CourseEntity> getCourse()
	{
		return courseService.getAllCourse();
	}
	
	@Operation(summary = "logout")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "logout successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="not found")})
	@org.springframework.web.bind.annotation.DeleteMapping("/deleteCourse")
	public void delete()
	{
		courseService.delete();
	}

}
