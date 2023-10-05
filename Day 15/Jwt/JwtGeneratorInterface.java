package com.example.thamarai.EvaluationofAP.Jwt;

import java.util.Map;

import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;

public interface JwtGeneratorInterface  {

	Map<String, String> generateToken(AdminEntity admin);
}
