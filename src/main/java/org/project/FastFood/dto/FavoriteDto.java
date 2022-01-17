package org.project.FastFood.dto;

public class FavoriteDto {
	private long id;
    private String favoriteId;
    private UserDto user;
    private RecipeDto recipe;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
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
	
	

}
