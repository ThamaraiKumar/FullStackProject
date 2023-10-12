package com.example.thamarai.EvaluationofAP.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.thamarai.EvaluationofAP.Entity.CourseEntity;
import com.example.thamarai.EvaluationofAP.Repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepo;
	
	public String postCourse(CourseEntity course)
	  {
		 courseRepo.save(course);
		  return "Course Added";
	  }
	 
	 public Optional<CourseEntity> getCourse(int courseid)
		{
			return courseRepo.findById(courseid);
		}
	 public void change(CourseEntity course)
		{
			courseRepo.save(course);
			System.out.println("Course updated Successfully");
		}
	 public void delete()
		{
			courseRepo.deleteAll();
		}

	 public Iterable<CourseEntity>getAllCourse()
	 {
		 return courseRepo.findAll();
	 }

}
