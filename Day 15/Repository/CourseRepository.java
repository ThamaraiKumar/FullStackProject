package com.example.thamarai.EvaluationofAP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thamarai.EvaluationofAP.Entity.CourseEntity;



@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

}
