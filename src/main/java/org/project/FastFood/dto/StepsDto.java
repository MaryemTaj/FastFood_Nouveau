package org.project.FastFood.dto;

public class StepsDto {
	
    private int id;
	private String description;
	private byte[] image;
	private String stepId;
	private RecipeDto recipe;
	public int getId() {
		return id;
	}
	
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
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	

	public RecipeDto getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeDto recipe) {
		this.recipe = recipe;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	
}
