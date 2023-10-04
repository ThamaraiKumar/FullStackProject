package com.example.thamarai.academicPerformance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thamarai.academicPerformance.Entity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, String> {

}
