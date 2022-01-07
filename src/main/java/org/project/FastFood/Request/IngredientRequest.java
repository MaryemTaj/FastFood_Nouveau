package org.project.FastFood.Request;

public class IngredientRequest {

	
	public String name;
	public String description;
	public String image;
	public int quantity;
	public String measure_type;
	
	public IngredientRequest() {
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
