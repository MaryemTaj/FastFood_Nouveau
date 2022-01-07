package org.project.FastFood.Response;

import java.util.Date;
import java.util.List;




public class RecipeResponse {

	public String image;
	public String video;
	public String name;
	public Date submit_date;
	public String servings_numbers;
	public String description;
	public String totals_views;
	public boolean featured;
	public String difficulty;
	public String prep_time;
	public String cook_time;
    public UserResponse user;
	
	
	
	public List<StepsResponse> steps_recipes;
	
	public CategorieResponse categorie;
	
	public  List<IngredientResponse> ingredients;
	
	public List<FavoriteResponse> favorites ;
	
	public List<ReactionResponse> reactions ;
	
	public List<CommentsResponse> comments;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(Date submit_date) {
		this.submit_date = submit_date;
	}

	public String getServings_numbers() {
		return servings_numbers;
	}

	public void setServings_numbers(String servings_numbers) {
		this.servings_numbers = servings_numbers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotals_views() {
		return totals_views;
	}

	public void setTotals_views(String totals_views) {
		this.totals_views = totals_views;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getPrep_time() {
		return prep_time;
	}

	public void setPrep_time(String prep_time) {
		this.prep_time = prep_time;
	}

	public String getCook_time() {
		return cook_time;
	}

	public void setCook_time(String cook_time) {
		this.cook_time = cook_time;
	}

	

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

	public List<StepsResponse> getSteps_recipes() {
		return steps_recipes;
	}

	public void setSteps_recipes(List<StepsResponse> steps_recipes) {
		this.steps_recipes = steps_recipes;
	}

	public CategorieResponse getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieResponse categorie) {
		this.categorie = categorie;
	}

	public List<IngredientResponse> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientResponse> ingredients) {
		this.ingredients = ingredients;
	}

	public List<FavoriteResponse> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<FavoriteResponse> favorites) {
		this.favorites = favorites;
	}

	public List<ReactionResponse> getReactions() {
		return reactions;
	}

	public void setReactions(List<ReactionResponse> reactions) {
		this.reactions = reactions;
	}

	public List<CommentsResponse> getComments() {
		return comments;
	}

	public void setComments(List<CommentsResponse> comments) {
		this.comments = comments;
	}

	
	
	
	

}
