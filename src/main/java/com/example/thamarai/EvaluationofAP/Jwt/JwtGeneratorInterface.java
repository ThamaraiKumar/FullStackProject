package com.example.thamarai.EvaluationofAP.Jwt;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;

@Service
public interface JwtGeneratorInterface {

	Map<String, String> generateToken(AdminEntity admin);

}
