package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.ReactionEntity;
import org.project.FastFood.Entity.RecipeEntity;
import org.project.FastFood.Entity.UserEntity;
import org.project.FastFood.Repository.ReactionRepository;
import org.project.FastFood.Repository.RecipeRepository;
import org.project.FastFood.Repository.UsersRepository;
import org.project.FastFood.Response.ErrorMessage;
import org.project.FastFood.Services.ReactionService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.ReactionDto;
import org.project.FastFood.dto.RecipeDto;
import org.project.FastFood.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReactionServiceImp implements ReactionService{
	
@Autowired
RecipeRepository recipeRepository;
@Autowired
UsersRepository userRepository;
@Autowired
ReactionRepository reactionRepository;
@Autowired
Utils util;


//add a reaction by user to a recipe 

	@Override
	public
	ReactionDto addReaction(ReactionDto reactionDto,String email) {
		//if already favorite
				ReactionEntity findReaction = reactionRepository.FindByRecipeAndUser(reactionDto.getRecipe().getRecipeId(),email);
				if(findReaction != null) throw new RuntimeException(" this user Already did a reaction!");
		ModelMapper modelMapper = new ModelMapper();
		
		RecipeEntity recipeEntity = recipeRepository.findByRecipeId(reactionDto.getRecipe().getRecipeId());
		RecipeDto recipeDto =modelMapper.map(recipeEntity, RecipeDto.class);
		
		UserEntity userEntity = userRepository.findByEmail(email);
		UserDto userDto = modelMapper.map(userEntity, UserDto.class);
		
		reactionDto.setReactionId(util.generateStringId(32));
		
		reactionDto.setRecipe(recipeDto);		
		reactionDto.setUser(userDto);
		
		ReactionEntity reactionEntity = modelMapper.map(reactionDto, ReactionEntity.class);
		
		ReactionEntity reactionSave = reactionRepository.save(reactionEntity);
		
		ReactionDto reaction = modelMapper.map(reactionSave, ReactionDto.class);
		return reaction;
		
	}
//get all reaction of user
	
    @Override
    public 
    List<ReactionDto> getAllReactionByUser(int page, int limit, String search, int status,String email){
    	
    	if(page > 0) page = page - 1;
		
		List<ReactionDto> reactionDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<ReactionEntity> reactionPage;		
		reactionPage = reactionRepository.findByUser(pageableRequest,email);				
		List<ReactionEntity> reactions = reactionPage.getContent();
		
		for(ReactionEntity reactionEntity: reactions) {
			
			ModelMapper modelMapper = new ModelMapper();	
			ReactionDto reaction = modelMapper.map(reactionEntity,ReactionDto.class);
			reactionDto.add(reaction);						
		}		
		return reactionDto;
	}
    
 //get all reaction of recipe  
    
	@Override
	public List<ReactionDto> getReactionByRecipe(int page, int limit, String search, int status, String recipeId) {
		
       if(page > 0) page = page - 1;
		
		List<ReactionDto> reactionDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<ReactionEntity> reactionPage;	
		
		reactionPage = reactionRepository.findByRecipe(pageableRequest,recipeId);
		
		List<ReactionEntity> reactions = reactionPage.getContent();
		
		for(ReactionEntity reactionEntity: reactions) {
			
			ModelMapper modelMapper = new ModelMapper();	
			ReactionDto reaction = modelMapper.map(reactionEntity,ReactionDto.class);
			reactionDto.add(reaction);						
		}		
		return reactionDto;
	}
	
//get User reacted on a recipe by emoji 
	
	@Override
	public List<UserDto> getUserReactedByEmoji(int page, int limit, String search, int status, String recipeId,String emoji) {
		
	       if(page > 0) page = page - 1;
			
			List<UserDto> userDto = new ArrayList<>();
			
			Pageable pageableRequest = PageRequest.of(page, limit);
			
			Page<UserEntity> userPage;	
			
			userPage = userRepository.findAllUsersByReactionEmojiAndRecipe(pageableRequest,recipeId,emoji);
			
			List<UserEntity> users = userPage.getContent();
			
			for(UserEntity userEntity: users) {
				
				ModelMapper modelMapper = new ModelMapper();	
				UserDto user = modelMapper.map(userEntity,UserDto.class);
				userDto.add(user);						
			}		
			return userDto;
		}

//count user reacter on a recipe by emoji 
	
	@Override
	public int countUserReactedByEmoji(String recipeId, String emoji) {
		int countUser = userRepository.countAllUsersByReactionEmojiAndRecipe(recipeId, emoji);
		return countUser;
	}

//count reaction
	
	@Override
	public int countReactionByRecipe(String recipeId) {
		int countReaction = reactionRepository.countByRecipe(recipeId);
		return countReaction;
	}
	
//update reaction	
	
	@Override
	public ReactionDto updateReactionByUser(ReactionDto reactionDto, String email) {
	    
		
		ReactionEntity reactionEntity = reactionRepository.findByReactionId(reactionDto.getReactionId());
		reactionEntity.setEmoji(reactionDto.getEmoji());
		ReactionEntity newReaction = reactionRepository.save(reactionEntity);
		ReactionDto newReactionDto = new ReactionDto();
		BeanUtils.copyProperties(newReaction,newReactionDto);
		
		
		return newReactionDto;
	}

//delete comment by user
	
	
		@Override
		public void deleteReactionByUser(String reactionId, String email) throws Exception {
			
			ReactionEntity reactionEntity = reactionRepository.findByReactionIdAndUser(reactionId,email);
			if(reactionEntity == null) throw new Exception(ErrorMessage.NO_RECORD_FOUND.getErrorMessage());
			reactionRepository.delete(reactionEntity);		
			
		}
			
	
    }

	
