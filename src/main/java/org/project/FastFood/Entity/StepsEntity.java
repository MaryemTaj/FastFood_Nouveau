package org.project.FastFood.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="T_steps")
public class StepsEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5811217083229025824L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	public String description;
	public byte[] image;
	

@ManyToOne 
public RecipeEntity recipe;


	public StepsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RecipeEntity getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
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


}
