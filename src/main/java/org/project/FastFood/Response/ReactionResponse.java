package org.project.FastFood.Response;

public class ReactionResponse {
	private String reactionId;
	private String emoji;
	
	private RecipeResponse recipe;
	private UserResponse user;
	
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
	
	public UserResponse getUser() {
		return user;
	}
	public void setUser(UserResponse user) {
		this.user = user;
	}
	
	
	
}
