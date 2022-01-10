package org.project.FastFood.Response;

import java.util.Date;


public class CommentsResponse {

public String text;
public Date date_comment;
public RecipeResponse recipe;

public UserResponse user;

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

}
