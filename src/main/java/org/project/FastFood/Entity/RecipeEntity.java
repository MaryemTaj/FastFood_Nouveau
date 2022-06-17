package org.project.FastFood.Entity;

import java.io.Serializable;
import java.sql.Blob;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_recipe")
public class RecipeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3286565895951101107L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Lob
	private byte[] image;
	@Lob
	private Blob video;
	@Column(nullable = false)
	private String name;
	private String pays;
	private String tags;
	private int servings_numbers;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date submit_date;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date update_date;
	private String description;
	private int totals_views;
	private boolean featured;
	private String difficulty;
	@Column(nullable = false)
	
	private String recipeId;
	@Column(nullable = false)
	private String prep_time;
	@Column(nullable = false)
	private String cook_time;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserEntity user;

	@OneToMany(mappedBy = "recipe")
	private List<StepsEntity> steps_recipes;

	@ManyToOne
	@JoinColumn(name = "id_cat")
	private CategorieEntity categorie;

	@OneToMany(mappedBy = "recipe")
	private List<IngredientEntity> ingredients;

	@OneToMany(mappedBy = "recipe")
	private List<FavoriteEntity> favorites;

	@OneToMany(mappedBy = "recipe")
	private List<ReactionEntity> reactions;

	@OneToMany(mappedBy = "recipe")
	private List<CommentsEntity> comments;

	public RecipeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getTotals_views() {
		return totals_views;
	}

	public void setTotals_views(int totals_views) {
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<StepsEntity> getSteps_recipes() {
		return steps_recipes;
	}

	public void setSteps_recipes(List<StepsEntity> steps_recipes) {
		this.steps_recipes = steps_recipes;
	}

	public CategorieEntity getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieEntity categorie) {
		this.categorie = categorie;
	}

	public List<IngredientEntity> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientEntity> ingredients) {
		this.ingredients = ingredients;
	}

	public List<FavoriteEntity> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<FavoriteEntity> favorites) {
		this.favorites = favorites;
	}

	public List<ReactionEntity> getReactions() {
		return reactions;
	}

	public void setReactions(List<ReactionEntity> reactions) {
		this.reactions = reactions;
	}

	public List<CommentsEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentsEntity> comments) {
		this.comments = comments;
	}

	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

}
