package org.project.FastFood.Request;

import java.util.List;


public class CategorieRequest {
	
	public String name;
	public String description;
	public String image;
	public String catId;
	public List<RecipeRequest> resipes ;
	public CategorieRequest() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<RecipeRequest> getResipes() {
		return resipes;
	}

	public void setResipes(List<RecipeRequest> resipes) {
		this.resipes = resipes;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}
	
	

}