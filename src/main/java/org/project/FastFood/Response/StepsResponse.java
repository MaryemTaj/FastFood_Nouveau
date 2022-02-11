package org.project.FastFood.Response;

public class StepsResponse {
	private int number_step;
	private String description;
	private byte[] image;
	private RecipeResponse recipe;
	
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
	public int getNumber_step() {
		return number_step;
	}
	public void setNumber_step(int number_step) {
		this.number_step = number_step;
	}
	
	
	

}
