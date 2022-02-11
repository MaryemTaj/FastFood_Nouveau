package org.project.FastFood.Request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class UserRequest {
	@NotNull(message = "Ce champ ne doit etre null !")
	@NotBlank(message = "Ce champ ne doit etre null !")
	private String firstname;
	
	@NotNull(message = "Ce champ ne doit etre null !")
	@NotBlank(message = "Ce champ ne doit etre null !")
	private String lastname;
	
	private String username;
	@NotNull(message = "Ce champ ne doit pas etre null !")
	@NotBlank(message = "Ce champ ne doit etre null !")
	private String password;
	
	
	private String phone;
	@NotBlank(message="Ce champ ne doit etre null !")
	@NotNull(message = "Ce champ ne doit pas etre null !")
	@Email(message = "ce champ doit respecter le format email !")
	private String email;
	
	private String image;

	private List<RecipeRequest> recipes;

	private List<CommentsRequest> comments;

	private List<FavoriteRequest> favorites;

	private List<ReactionRequest> reactions;
	
	private Set<String> roles ;

	public UserRequest() {
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
	
	


	

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
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

	public List<RecipeRequest> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<RecipeRequest> recipes) {
		this.recipes = recipes;
	}

	public List<CommentsRequest> getComments() {
		return comments;
	}

	public void setComments(List<CommentsRequest> comments) {
		this.comments = comments;
	}

	public List<FavoriteRequest> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<FavoriteRequest> favorites) {
		this.favorites = favorites;
	}

	public List<ReactionRequest> getReactions() {
		return reactions;
	}

	public void setReactions(List<ReactionRequest> reactions) {
		this.reactions = reactions;
	}


	

}
