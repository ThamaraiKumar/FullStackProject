package com.example.thamarai.EvaluationofAP.Service;

import org.springframework.stereotype.Service;

import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;
import com.example.thamarai.EvaluationofAP.Entity.StaffEntity;
import com.example.thamarai.EvaluationofAP.Entity.StudentEntity;
import com.example.thamarai.EvaluationofAP.Exception.UserNotFoundException;


@Service
public interface UserService {
	 public void saveUser(AdminEntity user);
	 public void saveUser(StudentEntity student);
	 public void saveUser(StaffEntity staff);
	    public AdminEntity getEmailidAndPassword(String name, String password) throws UserNotFoundException;
	    

}
