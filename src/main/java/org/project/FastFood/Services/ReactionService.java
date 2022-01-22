package org.project.FastFood.Services;


import java.util.List;

import org.project.FastFood.dto.ReactionDto;
import org.project.FastFood.dto.UserDto;

public interface ReactionService {



	ReactionDto addReaction(ReactionDto reactionDto, String email);
	List<ReactionDto> getAllReactionByUser(int page, int limit, String search, int status, String email);
	List<ReactionDto> getReactionByRecipe(int page, int limit, String search, int status, String recipeId);
	List<UserDto> getUserReactedByEmoji(int page, int limit, String search, int status, String recipeId, String emoji);
	int countUserReactedByEmoji(String recipeId,String emoji);
	int countReactionByRecipe(String recipeId);
	ReactionDto updateReactionByUser(ReactionDto reactionDto,String email);
	void deleteReactionByUser(String creactionId, String email) throws Exception;
	
   }
