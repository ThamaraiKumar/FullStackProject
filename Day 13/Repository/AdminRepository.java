package com.example.thamarai.academicPerformance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thamarai.academicPerformance.Entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {
	

}
