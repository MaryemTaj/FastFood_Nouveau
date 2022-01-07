package org.project.FastFood.dto;

import java.util.Date;




public class CommentsDto {
public long id;
public String text;
public Date date_comment;

public RecipeDto recipe;

public UserDto user;

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

}
