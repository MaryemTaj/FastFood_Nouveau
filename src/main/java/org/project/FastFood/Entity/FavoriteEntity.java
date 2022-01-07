package org.project.FastFood.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="T_favorite")
public class FavoriteEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -47527774887820364L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@ManyToOne @JoinColumn(name="id_user")
	public UserEntity user;
	@ManyToOne @JoinColumn(name="id_recipe")
	public RecipeEntity recipe;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public RecipeEntity getRecipe() {
		return recipe;
	}
	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
	}

}
