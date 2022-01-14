package org.project.FastFood.dto;

import java.io.Serializable;

public class IngredientDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -317952464106412308L;
	private int id;
	private String name;
	private String description;
	private byte[] image;
	private int quantity;
	private String measure_type;
	private RecipeDto recipe;
	private String IngredientId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
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
	public RecipeDto getRecipe() {
		return recipe;
	}
	public void setRecipe(RecipeDto recipe) {
		this.recipe = recipe;
	}
	public String getIngredientId() {
		return IngredientId;
	}
	public void setIngredientId(String ingredientId) {
		IngredientId = ingredientId;
	}
	
	

		
}
