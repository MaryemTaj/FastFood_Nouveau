package org.project.FastFood.Response;

import java.util.List;





public class CategorieResponse {
	
	private String name;
	private String description;
	private String image;


	private List<RecipeResponse> resipes ;

	
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

	public List<RecipeResponse> getResipes() {
		return resipes;
	}

	public void setResipes(List<RecipeResponse> resipes) {
		this.resipes = resipes;
	}
	
	

}
