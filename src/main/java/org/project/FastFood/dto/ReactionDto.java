package org.project.FastFood.dto;



public class ReactionDto {
	private String reactionId;
	private int id;
	private String emoji;
	private UserDto user;
	private RecipeDto recipe;

	public String getReactionId() {
		return reactionId;
	}
	public void setReactionId(String reactionId) {
		this.reactionId = reactionId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmoji() {
		return emoji;
	}
	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public RecipeDto getRecipe() {
		return recipe;
	}
	public void setRecipe(RecipeDto recipe) {
		this.recipe = recipe;
	}
	
	

}