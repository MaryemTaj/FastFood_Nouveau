package org.project.FastFood.Security;
import org.project.FastFood.Services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

	@EnableWebSecurity
	public class WebSecurity extends WebSecurityConfigurerAdapter {
		
		 private final UserService userDetailsService;
		  private final BCryptPasswordEncoder bCryptPasswordEncoder;
		  
		  public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		        this.userDetailsService = userDetailsService;
		        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		    }
		  
		  @Override
         protected void configure(HttpSecurity security) throws Exception
         {
          //security.httpBasic().disable(); // Did work only for GET     
          security.csrf().disable().authorizeRequests().anyRequest().permitAll(); // Works for GET, POST, PUT, DELETE
         }
		  /*@Override
		    @Bean
		    public AuthenticationManager authenticationManagerBean() throws Exception {
		        return super.authenticationManagerBean();
		    }*/

	}

