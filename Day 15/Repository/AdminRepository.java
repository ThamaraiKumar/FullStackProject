package com.example.thamarai.EvaluationofAP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;


@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {
	
//	public AdminEntity findByUserNameAndPassword(String emailId, String password);

}
