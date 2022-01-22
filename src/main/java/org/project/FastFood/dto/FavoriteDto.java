package org.project.FastFood.dto;

public class FavoriteDto {
	private long id;
    private String favId;
    private UserDto user;
    private RecipeDto recipe;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public RecipeDto getRecipe() {
		return recipe;
	}
	public void setRecipe(RecipeDto recipe) {
		this.recipe = recipe;
	}
	public String getFavId() {
		return favId;
	}
	public void setFavId(String favId) {
		this.favId = favId;
	}
	
	

}
