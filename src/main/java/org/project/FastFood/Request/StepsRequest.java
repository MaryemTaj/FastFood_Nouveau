package org.project.FastFood.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StepsRequest {
	@NotNull(message = "Ce champ ne doit etre null !")
	@NotBlank(message = "Ce champ ne doit etre null !")
	private int number_step;
	@NotNull(message = "Ce champ ne doit etre null !")
	@NotBlank(message = "Ce champ ne doit etre null !")
	private String description;
	private byte[] image;
	private RecipeRequest recipe;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public RecipeRequest getRecipe() {
		return recipe;
	}
	public void setRecipe(RecipeRequest recipe) {
		this.recipe = recipe;
	}
	public int getNumber_step() {
		return number_step;
	}
	public void setNumber_step(int number_step) {
		this.number_step = number_step;
	}
	
	
	
}
