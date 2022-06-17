package org.project.FastFood.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.project.FastFood.Entity.IngredientEntity;
import org.project.FastFood.Entity.RoleEntity;
import org.project.FastFood.Request.UserRequest;
import org.project.FastFood.ServicesImp.UserDetailsImpl;
import org.project.FastFood.Util.ERole;
import org.project.FastFood.dto.CommentsDto;
import org.project.FastFood.dto.FavoriteDto;
import org.project.FastFood.dto.ReactionDto;



public class UserResponse {

	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String image;
	
	private  List<RecipeResponse> recipe;

	private List<CommentsResponse> comments;

	private List<FavoriteResponse> favorites;

	private List<ReactionResponse> reactions;
	
	private Set<String> roles ;
	
	private UserRequest role;

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

public Set<String> getRoles() {
	UserRequest user = new UserRequest();
    Set<RoleResponse> roles = new HashSet<>();
	Set<String> strRoles = user.getRoles();
	for(RoleResponse users :roles) {
		roles.add(users);		
	}
	return strRoles;
	
}

public void setRoles(Set<String> roles) {
	this.roles = roles;
}


















}
