package org.project.FastFood.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity @Table(name="T_users")
public class UserEntity implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = -5692285355909500735L;
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String userId; 
private String firstname;
private String lastname;
private String username;
private String cryptedPassword;
private String phone;
private String email;
private String role;
@Temporal(TemporalType.TIMESTAMP)
@CreationTimestamp
private Date date_created;
@Lob
private byte[] image;
@OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
private List<RecipeEntity> recipes ;

@OneToMany(mappedBy="user" , fetch = FetchType.LAZY, cascade=CascadeType.ALL)
private List<CommentsEntity> comments;

@OneToMany(mappedBy="user" , fetch = FetchType.LAZY, cascade=CascadeType.ALL)
private List<FavoriteEntity> favorites;

@OneToMany(mappedBy="user"  ,fetch = FetchType.LAZY, cascade=CascadeType.ALL)
private List<ReactionEntity> reactions;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}



public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getCryptedPassword() {
	return cryptedPassword;
}

public void setCryptedPassword(String cryptedPassword) {
	this.cryptedPassword = cryptedPassword;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public Date getDate_created() {
	return date_created;
}

public void setDate_created(Date date_created) {
	this.date_created = date_created;
}

public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}

public List<RecipeEntity> getRecipes() {
	return recipes;
}

public void setRecipes(List<RecipeEntity> recipes) {
	this.recipes = recipes;
}

public List<CommentsEntity> getComments() {
	return comments;
}

public void setComments(List<CommentsEntity> comments) {
	this.comments = comments;
}

public List<FavoriteEntity> getFavorites() {
	return favorites;
}

public void setFavorites(List<FavoriteEntity> favorites) {
	this.favorites = favorites;
}

public List<ReactionEntity> getReactions() {
	return reactions;
}

public void setReactions(List<ReactionEntity> reactions) {
	this.reactions = reactions;
}









}