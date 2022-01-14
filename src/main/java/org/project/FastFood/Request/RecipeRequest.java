package org.project.FastFood.Request;


import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;



public class RecipeRequest {
	
	private String image;
	private String video;
	@NotNull(message = "Ce champ ne doit etre null !")
	private String name;
	
	private String servings_numbers;
	
	private String description;
	private String totals_views;
	private boolean featured;
	private String difficulty;
	@NotNull(message = "Ce champ ne doit etre null !")
	private String prep_time;
	@NotNull(message = "Ce champ ne doit etre null !")
	private String cook_time;
	
	private UserRequest user;
	private CategorieRequest categorie;	
		
		
	private List<StepsRequest> steps_recipes;
		
	private List<IngredientRequest> ingredients;
		
	private List<FavoriteRequest> favorites ;
		
	private List<ReactionRequest> reactions ;
		
	private List<CommentsRequest> comments;
	
	
	public RecipeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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

	public UserRequest getUser() {
		return user;
	}

	public void setUser(UserRequest user) {
		this.user = user;
	}

	public List<StepsRequest> getSteps_recipes() {
		return steps_recipes;
	}

	public void setSteps_recipes(List<StepsRequest> steps_recipes) {
		this.steps_recipes = steps_recipes;
	}

	public CategorieRequest getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieRequest categorie) {
		this.categorie = categorie;
	}

	public List<IngredientRequest> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientRequest> ingredients) {
		this.ingredients = ingredients;
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

	public List<CommentsRequest> getComments() {
		return comments;
	}

	public void setComments(List<CommentsRequest> comments) {
		this.comments = comments;
	}
	
	

}
