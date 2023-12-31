package com.example.thamarai.EvaluationofAP.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity

public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.cors().disable().csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(AntPathRequestMatcher.antMatcher("/admin/*")).permitAll()
		.and().authorizeHttpRequests().requestMatchers(AntPathRequestMatcher.antMatcher("/staff/*")).authenticated();
		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
		
		
		
		
		
//		.cors().disable()
//		.csrf().disable()
//		.authorizeHttpRequests()
//		.requestMatchers("/*")
//		.permitAll().and().authorizeHttpRequests().requestMatchers("/*").authenticated();
//		return httpSecurity.build();
//	}

}
