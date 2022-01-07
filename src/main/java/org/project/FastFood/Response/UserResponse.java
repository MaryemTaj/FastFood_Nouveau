package org.project.FastFood.Response;

import java.util.List;

import org.project.FastFood.Entity.IngredientEntity;
import org.project.FastFood.dto.CommentsDto;
import org.project.FastFood.dto.FavoriteDto;
import org.project.FastFood.dto.ReactionDto;



public class UserResponse {

public String firstname;
public String lastname;
public String phone;
public String email;
public String image;


public  List<RecipeResponse> recipe;


public List<CommentsResponse> comments;

public List<FavoriteResponse> favorites;

public List<ReactionResponse> reactions;

public UserResponse() {
	super();
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


public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}



}
