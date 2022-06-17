package org.project.FastFood.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.FastFood.Request.ReactionRequest;
import org.project.FastFood.Response.ReactionResponse;
import org.project.FastFood.Response.RecipeResponse;
import org.project.FastFood.Response.UserResponse;
import org.project.FastFood.Services.ReactionService;
import org.project.FastFood.dto.ReactionDto;
import org.project.FastFood.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/reaction")
@RestController
public class ReactionController {

@Autowired
ReactionService reactionService;



//Add reaction 
@PostMapping
 
  public ResponseEntity<ReactionResponse> addReaction(@RequestBody @Valid ReactionRequest reactionReq,Principal principal){
	
	ModelMapper modelMapper = new ModelMapper();
	modelMapper.getConfiguration()
    .setMatchingStrategy(MatchingStrategies.STRICT);
	ReactionDto reactionDto = modelMapper.map(reactionReq, ReactionDto.class);
	
	ReactionDto reaction = reactionService.addReaction(reactionDto, principal.getName());
	ReactionResponse reactionResponse = modelMapper.map(reaction, ReactionResponse.class);	
	return new ResponseEntity<ReactionResponse>(reactionResponse, HttpStatus.CREATED);
	
   }

//Get Reaction of a User on recipes

@GetMapping
public ResponseEntity<List<ReactionResponse>> getReactionOfUser(
		@RequestParam(value = "page", defaultValue = "1") int page,
		@RequestParam(value = "limit", defaultValue = "4") int limit,
		@RequestParam(value = "search", defaultValue = "") String search,
		@RequestParam(value = "status", defaultValue = "1") int status,		
		Principal principal){
	
	    List<ReactionResponse> reactionsRes = new ArrayList<>();
	    List<ReactionDto> reactions = reactionService.getAllReactionByUser(page, limit, search, status, principal.getName());
	  for(ReactionDto reactionDto : reactions) {
	    	
	    	ModelMapper modelMapper = new ModelMapper();
	    	
	    	ReactionResponse reactionResponse = modelMapper.map(reactionDto, ReactionResponse.class);
	    	
	    	reactionsRes.add(reactionResponse); 		    	
	    }
	
	  return new ResponseEntity<List<ReactionResponse>>(reactionsRes,HttpStatus.OK);
	
}

//get reaction of recipe

@GetMapping("/recipe")
public ResponseEntity<List<ReactionResponse>> getReactionOfRecipe(
		@RequestParam(value = "page", defaultValue = "1") int page,
		@RequestParam(value = "limit", defaultValue = "4") int limit,
		@RequestParam(value = "search", defaultValue = "") String search,
		@RequestParam(value = "status", defaultValue = "1") int status,		
		@RequestBody RecipeResponse recipe){
	
	    List<ReactionResponse> reactionsRes = new ArrayList<>();
	    List<ReactionDto> reactions = reactionService.getReactionByRecipe(page, limit, search, status,recipe.getRecipeId());
	    for(ReactionDto reactionDto : reactions) {
	    	
	    	ModelMapper modelMapper = new ModelMapper();
	    	
	    	ReactionResponse reactionResponse = modelMapper.map(reactionDto, ReactionResponse.class);
	    	
	    	reactionsRes.add(reactionResponse); 		    	
	    }
	
	  return new ResponseEntity<List<ReactionResponse>>(reactionsRes,HttpStatus.OK);
	
}

//get user reacted on a recipe by emoji

@GetMapping("/userReacted")
public ResponseEntity<List<UserResponse>> getUserReactedOnRecipeByEmoji(
		@RequestParam(value = "page", defaultValue = "1") int page,
		@RequestParam(value = "limit", defaultValue = "4") int limit,
		@RequestParam(value = "search", defaultValue = "") String search,
		@RequestParam(value = "status", defaultValue = "1") int status,		
		@RequestBody ReactionRequest reaction){
	
	    List<UserResponse> usersRes = new ArrayList<>();
	    List<UserDto> users = reactionService.getUserReactedByEmoji(page, limit, search, status,reaction.getRecipe().getRecipeId(),reaction.getEmoji());
	    for(UserDto userDto : users) {
	    	
	    	ModelMapper modelMapper = new ModelMapper();
	    	
	    	UserResponse userResponse = modelMapper.map(userDto, UserResponse.class);
	    	
	    	usersRes.add(userResponse); 		    	
	    }
	
	  return new ResponseEntity<List<UserResponse>>(usersRes,HttpStatus.OK);
	
}


//Count User Reacted By Emoji
@GetMapping("/n")
public int countUserReactedByEmoji(@RequestBody ReactionRequest reaction) {	
	int countUser =reactionService.countUserReactedByEmoji(reaction.getRecipe().getRecipeId(), reaction.getEmoji());
	return countUser;
}

//Count User Reacted By All Emoji
@GetMapping("/allReaction")
public int countUserReactedByAllEmoji(@RequestBody ReactionRequest reaction) {	
	int countReaction = reactionService.countReactionByRecipe(reaction.getRecipe().getRecipeId());
	return countReaction;
}


//update reaction
@PutMapping
public ResponseEntity<ReactionResponse> updateReaction(@RequestBody ReactionRequest reactionR, Principal principal){
	
	ReactionDto reactionDto = new ReactionDto();
	BeanUtils.copyProperties(reactionR, reactionDto);
	ReactionDto updateReaction = reactionService.updateReactionByUser(reactionDto, principal.getName());
	ReactionResponse reactionResponse = new ReactionResponse();
	BeanUtils.copyProperties(updateReaction, reactionResponse);
	
	return new ResponseEntity<ReactionResponse>(reactionResponse, HttpStatus.ACCEPTED);
}

//delete reaction

	@DeleteMapping("/{reactionId}")
	public ResponseEntity<Object> deleteReactionByUser(@PathVariable String reactionId,Principal principal) throws Exception {

		reactionService.deleteReactionByUser(reactionId,principal.getName());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} 
}



