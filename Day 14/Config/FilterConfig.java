package com.example.thamarai.EvaluationofAP.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.thamarai.EvaluationofAP.Jwt.JwtFilter;

public class FilterConfig {

	@Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
        // provide endpoints which needs to be restricted.
        // All Endpoints would be restricted if unspecified
       filter.addUrlPatterns("/admin/restricted");
    return filter;
	}
}
