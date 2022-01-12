package org.project.FastFood.Request;

import java.util.Date;


public class CommentsRequest {

	private String text;
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

}
