package org.project.FastFood.dto;

import java.io.Serializable;
import java.util.List;


public class CategorieDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6359680698770777515L;
	private long id;
	private String name;
	private String description;
	private String image;
	private String catId;
	private List<RecipeDto> recipes ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public List<RecipeDto> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<RecipeDto> recipes) {
		this.recipes = recipes;
	}
	
	
	

}
