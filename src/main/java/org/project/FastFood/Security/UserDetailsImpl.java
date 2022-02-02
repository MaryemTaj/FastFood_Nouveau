package org.project.FastFood.Security;

import java.util.Arrays;
import java.util.Collection;

import java.util.stream.Collectors;

import org.project.FastFood.Entity.UserEntity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L;

	
	  private String username;

	  private String email;

	  @JsonIgnore
	  private String password;

	  private Collection<? extends GrantedAuthority> authorities;

	

		  

		     public UserDetailsImpl() {
		
	}


			//get the db values and set it to user 
			 public UserDetailsImpl(UserEntity user) {
				    this.email = user.getEmail();
			        this.username = user.getUsername();
			        this.password = user.getCryptedPassword();			    
			        this.authorities = Arrays.stream(user.getRole().split(","))
			                    .map(SimpleGrantedAuthority::new)
			                    .collect(Collectors.toList());
			    }


			 @Override
			    public Collection<? extends GrantedAuthority> getAuthorities() {
			        return authorities;
			    }


			    @Override
			    public String getPassword() {
		          
			        return password;
			    }


			    @Override
			    public String getUsername() {
			        return username;
			    }


			    @Override
			    public boolean isAccountNonExpired() {
			        return true;
			    }


			    @Override
			    public boolean isAccountNonLocked() {
			        return true;
			    }


			    @Override
			    public boolean isCredentialsNonExpired() {
			        return true;
			    }


				@Override
				public boolean isEnabled() {
					// TODO Auto-generated method stub
					return true;
				}


				public String getEmail() {
					return email;
				}


				public void setEmail(String email) {
					this.email = email;
				}


			    
			
			
			


		}
	
	
