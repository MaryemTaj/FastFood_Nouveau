package org.project.FastFood.Response;

import java.util.Date;


public class CommentsResponse {

	private String text;
	private Date date_comment;
	private RecipeResponse recipe;
    private String commentId;
	private UserResponse user;

public CommentsResponse() {
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

public RecipeResponse getRecipe() {
	return recipe;
}

public void setRecipe(RecipeResponse recipe) {
	this.recipe = recipe;
}

public UserResponse getUser() {
	return user;
}

public void setUser(UserResponse user) {
	this.user = user;
}

public String getCommentId() {
	return commentId;
}

public void setCommentId(String commentId) {
	this.commentId = commentId;
}





}
