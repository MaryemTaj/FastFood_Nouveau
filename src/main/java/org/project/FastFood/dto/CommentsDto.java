package org.project.FastFood.dto;

import java.io.Serializable;
import java.util.Date;




public class CommentsDto implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 4435880361039800115L;
private long id;
private String text;
private Date date_comment;

private RecipeDto recipe;

private UserDto user;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public Date getDate_comment() {
	return date_comment;
}

public void setDate_comment(Date date_comment) {
	this.date_comment = date_comment;
}

public RecipeDto getRecipe() {
	return recipe;
}

public void setRecipe(RecipeDto recipe) {
	this.recipe = recipe;
}

public UserDto getUser() {
	return user;
}

public void setUser(UserDto user) {
	this.user = user;
}


}
