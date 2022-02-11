package org.project.FastFood.Request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategorieRequest {
	
	private String catId;
	@NotBlank(message = "Ce champ ne doit etre null !")
	@NotNull(message = "Ce champ ne doit etre null !")
	private String name;
	private String description;
	private String image;


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

}
