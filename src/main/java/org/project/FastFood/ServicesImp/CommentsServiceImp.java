package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.CommentsEntity;
import org.project.FastFood.Entity.RecipeEntity;
import org.project.FastFood.Entity.UserEntity;
import org.project.FastFood.Repository.CommentsRepository;
import org.project.FastFood.Repository.RecipeRepository;
import org.project.FastFood.Repository.UsersRepository;
import org.project.FastFood.Response.ErrorMessage;
import org.project.FastFood.Services.CommentsService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.CommentsDto;
import org.project.FastFood.dto.RecipeDto;
import org.project.FastFood.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class CommentsServiceImp implements CommentsService{

	@Autowired
	CommentsRepository commentRepository;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	RecipeRepository recipeRepository;
	@Autowired
	Utils util;

//Add Comment
	
	@Override
	public CommentsDto AddComments(CommentsDto comment, String email) {
		ModelMapper modelMapper = new ModelMapper();
		UserEntity currentUser = userRepository.findByEmail(email);
		UserDto userDto = modelMapper.map(currentUser, UserDto.class);
		
		comment.setUser(userDto);
		
		RecipeEntity recipeEntity = recipeRepository.findByRecipeId(comment.getRecipe().getRecipeId());
		RecipeDto recipeDto = modelMapper.map(recipeEntity, RecipeDto.class);
		
		comment.setRecipe(recipeDto);
		comment.setCommentId(util.generateStringId(32));
		
		CommentsEntity saveComment = modelMapper.map(comment, CommentsEntity.class);
		
		CommentsEntity commentEntity = commentRepository.save(saveComment);
		
		CommentsDto newComment = modelMapper.map(commentEntity, CommentsDto.class);		
		return newComment;
	}
	
	
//update Comment
	
		@Override
		public CommentsDto updateComments(CommentsDto comment, String email) {
			CommentsEntity commentEntity = commentRepository.findByCommentId(comment.getCommentId());
			commentEntity.setText(comment.getText());
			CommentsEntity newComment = commentRepository.save(commentEntity);
			CommentsDto newCommentDto = new CommentsDto();
			BeanUtils.copyProperties(newComment,newCommentDto);
			
			
			return newCommentDto;
		}
	
//get comments
		
	@Override
	
	public List<CommentsDto> getComments(int page, int limit, String search, int status,String recipeId) {
		
		
		 if(page > 0) page = page - 1;
			
			List<CommentsDto> commentDto = new ArrayList<>();
			
			Pageable pageableRequest = PageRequest.of(page, limit);
			
			Page<CommentsEntity> commentPage;	
			
			commentPage = commentRepository.findByRecipe(pageableRequest,recipeId);
			
			List<CommentsEntity> comments = commentPage.getContent();
			
			for(CommentsEntity commentEntity: comments) {
				
				ModelMapper modelMapper = new ModelMapper();	
				CommentsDto comment = modelMapper.map(commentEntity,CommentsDto.class);
				commentDto.add(comment);						
			}		
			return commentDto;
		}
//delete comment by user
	
	@Override
	
	public void deleteCommentByUser(String commentsId, String email) throws Exception {
		
		CommentsEntity comEntity = commentRepository.findByCommentIdAndUser(commentsId,email);
		if(comEntity == null) throw new Exception(ErrorMessage.NO_RECORD_FOUND.getErrorMessage());
		commentRepository.delete(comEntity);		
		
	}
	
}
