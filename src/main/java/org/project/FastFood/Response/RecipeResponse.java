package org.project.FastFood.Response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;




public class RecipeResponse {
	private String recipeId;
	private UserResponse user;	
	private String name;
	private String description;
	private String prep_time;
	private String cook_time;
	private String image;
	private String video;
	
	 @JsonIgnore
	private Date submit_date;
	 private int servings_numbers;
	
	private String totals_views;
	private boolean featured;
	private String difficulty;

	private Date update_date;
	private String pays;
	private String tags;
	private List<StepsResponse> steps_recipes;
	
	private CategorieResponse categorie;
	
	private  List<IngredientResponse> ingredients;
	
	private List<FavoriteResponse> favorites;
	
	private List<ReactionResponse> reactions ;
	
	private List<CommentsResponse> comments;
	
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
     
	

	public int getServings_numbers() {
		return servings_numbers;
	}

	public void setServings_numbers(int servings_numbers) {
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

	
	public CategorieResponse getCategorie() {
		return categorie;
	}

	

	public void setIngredients(List<IngredientResponse> ingredients) {
		this.ingredients = ingredients;
	}

	
	


	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	public List<StepsResponse> getSteps_recipes() {
		return steps_recipes;
	}

	public void setSteps_recipes(List<StepsResponse> steps_recipes) {
		this.steps_recipes = steps_recipes;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setCategorie(CategorieResponse categorie) {
		this.categorie = categorie;
	}

	public List<IngredientResponse> getIngredients() {
		return ingredients;
	}

	public List<ReactionResponse> getReactions() {
		return reactions;
	}

	public void setReactions(List<ReactionResponse> reactions) {
		this.reactions = reactions;
	}

	public List<FavoriteResponse> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<FavoriteResponse> favorites) {
		this.favorites = favorites;
	}

	public List<CommentsResponse> getComments() {
		return comments;
	}

	public void setComments(List<CommentsResponse> comments) {
		this.comments = comments;
	}
	
	
	

	

	
	
	
	

}
