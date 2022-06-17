package org.project.FastFood.Response;

import org.project.FastFood.Entity.RecipeEntity;

public class IngredientResponse {

	private String ingredientId;
	private String name;
	private String description;
	private String image;
	private int quantity;
	private String measure_type;
	private RecipeResponse recipe;

	public IngredientResponse() {
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getMeasure_type() {
		return measure_type;
	}
	public void setMeasure_type(String measure_type) {
		this.measure_type = measure_type;
	}
		
}
