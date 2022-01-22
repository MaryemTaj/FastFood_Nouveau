package org.project.FastFood.Response;

public class FavoriteResponse {
	private String favId;
private UserResponse user;
private RecipeResponse recipe;

public RecipeResponse getRecipe() {
	return recipe;
}

public void setRecipe(RecipeResponse recipe) {
	this.recipe = recipe;
}

public UserResponse getUser() {
	return user;
}

public void setUser(UserResponse user) {
	this.user = user;
}

public String getFavId() {
	return favId;
}

public void setFavId(String favId) {
	this.favId = favId;
}


}
