package org.project.FastFood.ServicesImp;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.project.FastFood.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private String userId;

  private String username;

  private String email;

  @JsonIgnore
  private String Password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(String userId, String username, String email,String Password,
      Collection<? extends GrantedAuthority> authorities ) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.Password = Password;
    this.authorities = authorities;
  }
  
  

  public UserDetailsImpl() {
	super();
	// TODO Auto-generated constructor stub
}



public static UserDetailsImpl build(UserEntity user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		return new UserDetailsImpl(
				user.getUserId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getCryptedPassword(), 
				authorities);}


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

 

  public String getEmail() {
    return email;
  }

  
  

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public void setPassword(String password) {
	Password = password;
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
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(userId, user.userId);
  }



@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return Password;
}
  
  
  
}
