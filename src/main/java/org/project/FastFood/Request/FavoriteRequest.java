package org.project.FastFood.Request;

public class FavoriteRequest {
	private RecipeRequest recipe;
    private String favId;
	public RecipeRequest getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeRequest recipe) {
		this.recipe = recipe;
	}

	public String getFavId() {
		return favId;
	}

	public void setFavId(String favId) {
		this.favId = favId;
	}
	
	
	
}
