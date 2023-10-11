package com.example.thamarai.EvaluationofAP.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.thamarai.EvaluationofAP.Jwt.JwtFilter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
       filter.addUrlPatterns("/admin/restricted");
    return filter;
    }
}