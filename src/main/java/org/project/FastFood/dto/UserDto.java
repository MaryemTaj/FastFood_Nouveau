package org.project.FastFood.dto;

import java.util.Date;
import java.util.List;


public class UserDto {
public long id;
public String userId;
public String firstname;
public String lastname;
public String username;
public String password;
public String cryptedPassword;
public String phone;
public String email;
public String role;
public Date date_created;
public byte[] image;

public List<RecipeDto> recipes ;

public List<CommentsDto> comments;

public List<FavoriteDto> favorites;

public List<ReactionDto> reactions;





public UserDto() {
	super();
}

public String getFirstname() {
	return firstname;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
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

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public List<RecipeDto> getRecipes() {
	return recipes;
}
public void setRecipes(List<RecipeDto> recipes) {
	this.recipes = recipes;
}
public List<CommentsDto> getComments() {
	return comments;
}
public void setComments(List<CommentsDto> comments) {
	this.comments = comments;
}

public List<FavoriteDto> getFavorites() {
	return favorites;
}
public void setFavorites(List<FavoriteDto> favorites) {
	this.favorites = favorites;
}
public List<ReactionDto> getReactions() {
	return reactions;
}
public void setReactions(List<ReactionDto> reactions) {
	this.reactions = reactions;
}
public String getCryptedPassword() {
	return cryptedPassword;
}
public void setCryptedPassword(String cryptedPassword) {
	this.cryptedPassword = cryptedPassword;
}






}
