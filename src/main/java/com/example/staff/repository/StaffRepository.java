package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, String> {
	

}
