package org.project.FastFood.Entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity @Table(name="T_categorie")
public class CategorieEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6546842318111390210L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false ,unique = true)
	private String name;
	private String description;
	private String image;
	private String catId;
	 @OneToMany(mappedBy="categorie")
	 private List<RecipeEntity> recipes;
	 

	
	
	public String getName() {
		return name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public List<RecipeEntity> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<RecipeEntity> recipes) {
		this.recipes = recipes;
	}
	


	

}
