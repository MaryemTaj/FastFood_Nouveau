package org.project.FastFood.dto;


import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;


import org.project.FastFood.Entity.CategorieEntity;
import org.project.FastFood.Entity.CommentsEntity;
import org.project.FastFood.Entity.FavoriteEntity;
import org.project.FastFood.Entity.IngredientEntity;
import org.project.FastFood.Entity.ReactionEntity;
import org.project.FastFood.Entity.StepsEntity;


public class RecipeDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -195580891806545515L;
	private long id;
	private byte[] image;
	private Blob video;
	private String name;
	private String steps;
	private int servings_numbers;
	private Date submit_date;
	private Date update_date;
	private String description;
	private String totals_views;
	private boolean featured;
	private String difficulty;
	private String prep_time;
	private String cook_time;
	private String pays;
	private String tags;
	private String recipId;
	private UserDto user;
	private CategorieDto categorie;
	
	private List<StepsDto> steps_recipes;
	
	
	
	private  List<IngredientDto> ingredients;
	
	private List<FavoriteDto> favorites ;
	
	private List<ReactionDto> reactions ;
	
	private List<CommentsDto> comments;
	
	public RecipeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	 
	public Blob getVideo() {
		return video;
	}


	public void setVideo(Blob video) {
		this.video = video;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	
	public int getServings_numbers() {
		return servings_numbers;
	}


	public void setServings_numbers(int servings_numbers) {
		this.servings_numbers = servings_numbers;
	}


	public Date getSubmit_date() {
		return submit_date;
	}
	public void setSubmit_date(Date submit_date) {
		this.submit_date = submit_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
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
	

	public UserDto getUser() {
		return user;
	}


	public void setUser(UserDto user) {
		this.user = user;
	}


	public List<StepsDto> getSteps_recipes() {
		return steps_recipes;
	}


	public void setSteps_recipes(List<StepsDto> steps_recipes) {
		this.steps_recipes = steps_recipes;
	}


	public CategorieDto getCategorie() {
		return categorie;
	}


	public void setCategorie(CategorieDto categorie) {
		this.categorie = categorie;
	}


	public List<IngredientDto> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<IngredientDto> ingredients) {
		this.ingredients = ingredients;
	}


	public List<FavoriteDto> getFavorites() {
		return favorites;
	}


	public void setFavorites(List<FavoriteDto> favorites) {
		this.favorites = favorites;
	}


	public List<ReactionDto> getReactions() {
		return reactions;
	}


	public void setReactions(List<ReactionDto> reactions) {
		this.reactions = reactions;
	}


	public List<CommentsDto> getComments() {
		return comments;
	}


	public void setComments(List<CommentsDto> comments) {
		this.comments = comments;
	}


	public String getRecipId() {
		return recipId;
	}


	public void setRecipId(String recipId) {
		this.recipId = recipId;
	}
	
	
	

}
