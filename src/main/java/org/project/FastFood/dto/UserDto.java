package org.project.FastFood.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDto implements  Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = -4973691837112404108L;
private long id;
private String userId;
private String firstname;
private String lastname;
private String username;
private String password;
private String cryptedPassword;
private String phone;
private String email;

private Date date_created;
private byte[] image;

private List<RecipeDto> recipes ;

private List<CommentsDto> comments;

private List<FavoriteDto> favorites;

private List<ReactionDto> reactions;
private Set<String> roles ;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCryptedPassword() {
	return cryptedPassword;
}

public void setCryptedPassword(String cryptedPassword) {
	this.cryptedPassword = cryptedPassword;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



public Date getDate_created() {
	return date_created;
}

public void setDate_created(Date date_created) {
	this.date_created = date_created;
}

public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}

public Set<String> getRoles() {
	return roles;
}

public void setRoles(Set<String> roles) {
	this.roles = roles;
}

public List<RecipeDto> getRecipes() {
	return recipes;
}

public void setRecipes(List<RecipeDto> recipes) {
	this.recipes = recipes;
}

















}
