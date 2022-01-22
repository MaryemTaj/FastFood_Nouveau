package org.project.FastFood.Request;



public class ReactionRequest {
	
	private int id;
	private String emoji;
	private String reactionId;
	private RecipeRequest recipe;
	private UserRequest user;
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
	
	public String getReactionId() {
		return reactionId;
	}
	public void setReactionId(String reactionId) {
		this.reactionId = reactionId;
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
	
	

}
