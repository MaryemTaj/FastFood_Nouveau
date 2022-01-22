package org.project.FastFood.Request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CommentsRequest {
	@NotNull(message = "Ce champ ne doit etre null !")
	@NotBlank(message = "Ce champ ne doit etre null !")
	private String text;
	private String commentId;
	private Date date_comment;
	private RecipeRequest recipe;

	private UserRequest user;

public CommentsRequest() {
	super();
	// TODO Auto-generated constructor stub
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

public RecipeRequest getRecipe() {
	return recipe;
}

public void setRecipe(RecipeRequest recipe) {
	this.recipe = recipe;
}

public UserRequest getUser() {
	return user;
}

public void setUser(UserRequest user) {
	this.user = user;
}

public String getCommentId() {
	return commentId;
}

public void setCommentId(String commentId) {
	this.commentId = commentId;
}

}
