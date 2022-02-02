package org.project.FastFood.Request;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.project.FastFood.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

public class UserLoginRequest implements UserDetails {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 807185162682523777L;

		private String email;
		
		private String password;
		
		private String username;
		
		  private Collection<? extends GrantedAuthority> authorities;
		
		

		public UserLoginRequest() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	 //get the db values and set it to user 
           public UserLoginRequest(UserDto user) {
        	this.email = user.getEmail();   
	        this.username = user.getUsername();
	        this.password = user.getPassword();
	      //this.active = user.isActive();
	        this.authorities = Arrays.stream(user.getRole().split(","))
	                    .map(SimpleGrantedAuthority::new)
	                    .collect(Collectors.toList());
	    }
	
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}
		
		

	}

