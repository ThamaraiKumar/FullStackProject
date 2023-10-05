package com.example.thamarai.EvaluationofAP.Jwt;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

public class JwtFilter extends GenericFilterBean  {
	
	@Override
    public void doFilter(ServletRequest servletRequest, ServletRequest servletResponse, FilterChain filterChain)
    		throws IOException, ServletException {
           final HttpServletRequest request = (HttpServletRequest) servletRequest;
           final HttpServletRequest response = (HttpServletRequest) servletResponse;
           final String authHeader = request.getHeader("authorization");
           if ("OPTIONS".equals(request.getMethod())) {
               response.setStatus(HttpServletRequest.SC_OK);
               filterChain.doFilter(request,response);
           } else {
               if(authHeader == null || !authHeader.startsWith("Bearer ")){
                   throw new ServletException("An exception occurred");
               }  
           }
           final String token = authHeader.substring(7);
           Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
           request.setAttribute("claims", claims);
           request.setAttribute("blog", servletRequest.getParameter("id"));
           filterChain.doFilter(request, response);
    }

}
