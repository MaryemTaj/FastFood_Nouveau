package org.project.FastFood.Request;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CategorieRequest {
	@NotNull(message = "Ce champ ne doit etre null !")
	
	private String name;
	private String description;
	private String image;

	private List<RecipeRequest> resipes;

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

}
