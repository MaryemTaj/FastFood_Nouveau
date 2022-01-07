package org.project.FastFood.dto;

import java.util.List;

import org.project.FastFood.Entity.RecipeEntity;

public class CategorieDto {
	public long id;
	public String name;
	public String description;
	public String image;
	public String catId;
	public List<RecipeDto> recipes ;
	public CategorieDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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

	public List<RecipeDto> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<RecipeDto> recipes) {
		this.recipes = recipes;
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
	
	

}
