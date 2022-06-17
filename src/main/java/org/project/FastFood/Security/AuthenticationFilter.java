package org.project.FastFood.Security;

import javax.servlet.http.HttpServletResponse;

import org.project.FastFood.Login.SpringApplicationContext;
import org.project.FastFood.Request.UserLoginRequest;
import org.project.FastFood.Services.UserService;
import org.project.FastFood.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;



import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	/*private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {

			UserLoginRequest creds = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequest.class);

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	  @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
	        
	        String userName = ((User) auth.getPrincipal()).getUsername(); 
	        
	    
	       /* List<String> authorities = auth.getAuthorities().stream()
	                .map(role -> role.getAuthority())
	                .collect(Collectors.toList());
	     */
	        
           /* UserService userService = (UserService)SpringApplicationContext.getBean("userServiceImp");	        
	        UserDto userDto = userService.getUser(userName);	        
	        String token = Jwts.builder()
	                .setSubject(userName)
	                .claim("id", userDto.getUserId())
	                .claim("name", userDto.getFirstname() + " " + userDto.getLastname())
	                .claim("authorities", userDto.getAuthorities())
	                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET )
	                .compact();
	        
	       
	       
	        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	        res.addHeader("user_id", userDto.getUserId());
	       
	        res.getWriter().write("{\"token\": \"" + token + "\", "
	        		        + "\"id\": \""+ userDto.getUserId() + "\", "
	        				+ "\"role\": \""+ userDto.getAuthorities() + "\","
	        				+ "\"name\": \""+ userDto.getFirstname() + " " + userDto.getLastname()+"\"}");

	    } */
}

