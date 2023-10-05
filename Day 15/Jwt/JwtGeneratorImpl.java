package com.example.thamarai.EvaluationofAP.Jwt;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.example.thamarai.EvaluationofAP.Entity.AdminEntity;

import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import io.jsonwebtoken.Jwts;

public class JwtGeneratorImpl implements JwtGeneratorInterface{
	
	@Value("${jwt.secret}")
	  private String secret;
	  @Value("${app.jwttoken.message}")
	  private String message;
	  @Override
	  public Map<String, String> generateToken(AdminEntity user) {
	    String jwtToken="";
	    jwtToken = Jwts.builder().setSubject(user.getEmailid()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
	    Map<String, String> jwtTokenGen = new HashMap<>();
	    jwtTokenGen.put("token", jwtToken);
	    jwtTokenGen.put("message", message);
	    return jwtTokenGen;
	  }

}
