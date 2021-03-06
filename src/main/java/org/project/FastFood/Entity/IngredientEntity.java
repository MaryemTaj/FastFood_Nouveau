package org.project.FastFood.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="T_ingredient")
public class IngredientEntity implements Serializable{

	private static final long serialVersionUID = 8235157328120464229L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(nullable = false)
	private String name;
	private String description;
	@Lob
	private byte[] image;
	private int quantity;
	 @Column(nullable = false)
	private String measure_type;
	 @Column(nullable = false)
	private String ingredientId;
	@ManyToOne @JoinColumn(name="id_recipe")
	private RecipeEntity recipe;
	
	public IngredientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public RecipeEntity getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
	}

	public String getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}
	

	
		
}
