package org.project.FastFood.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity @Table(name="T_comments")
public class CommentsEntity implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 8989443625010538348L;
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
@Column(nullable = false)
private String text;
@Temporal(TemporalType.TIMESTAMP)
@CreationTimestamp
private Date date_comment;

private String commentId;

@ManyToOne
@JoinColumn(name="id_recipe")
private RecipeEntity recipe;

@ManyToOne
@JoinColumn(name="id_user")
private UserEntity user;


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
public UserEntity getUser() {
	return user;
}
public void setUser(UserEntity user) {
	this.user = user;
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
public String getCommentId() {
	return commentId;
}
public void setCommentId(String commentId) {
	this.commentId = commentId;
}

}
