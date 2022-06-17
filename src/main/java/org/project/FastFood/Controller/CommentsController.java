package org.project.FastFood.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.FastFood.Request.CommentsRequest;
import org.project.FastFood.Request.ReactionRequest;
import org.project.FastFood.Response.CommentsResponse;
import org.project.FastFood.Response.ReactionResponse;
import org.project.FastFood.Services.CommentsService;
import org.project.FastFood.dto.CommentsDto;
import org.project.FastFood.dto.ReactionDto;
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

@RestController
@RequestMapping("/comments")
public class CommentsController {
	
	@Autowired
	CommentsService commentService;
	
//Add Comment	
	@PostMapping	
	ResponseEntity<CommentsResponse> addComments(@RequestBody CommentsRequest commentsReq ,Principal principal){
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
	    .setMatchingStrategy(MatchingStrategies.STRICT);
		CommentsDto commentsDto = modelMapper.map(commentsReq, CommentsDto.class);
		
		CommentsDto newComment = commentService.AddComments(commentsDto, principal.getName());
		 
		CommentsResponse comment = modelMapper.map(newComment,CommentsResponse.class);
		return new ResponseEntity<CommentsResponse>(comment,HttpStatus.CREATED);
	}

//get Comments of a recipes
	@GetMapping
	public ResponseEntity<List<CommentsResponse>> getComments(
			@RequestBody CommentsRequest commentsReq,			
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "4") int limit,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "status", defaultValue = "1") int status	){
		

	        List<CommentsResponse> commentsRes = new ArrayList<>();
	        List<CommentsDto> comments = commentService.getComments(page, limit, search, status, commentsReq.getRecipe().getRecipeId());
	    
	        for(CommentsDto commentDto : comments) {	
	    	  
	    	ModelMapper modelMapper = new ModelMapper();
	    	
	    	CommentsResponse commentResponse = modelMapper.map(commentDto, CommentsResponse.class);
	    	
	    	commentsRes.add(commentResponse); 		    	
	    }
	
		return new ResponseEntity<List<CommentsResponse>>(commentsRes,HttpStatus.OK);
	}
	
	//update Comment
	@PutMapping
	public ResponseEntity<CommentsResponse> updateComment(@RequestBody CommentsRequest commentR, Principal principal){
		
		CommentsDto commentDto = new CommentsDto();
		BeanUtils.copyProperties(commentR, commentDto);
		CommentsDto updateComment = commentService.updateComments(commentDto, principal.getName());
		CommentsResponse commentResponse = new CommentsResponse();
		BeanUtils.copyProperties(updateComment, commentResponse);
		
		return new ResponseEntity<CommentsResponse>(commentResponse, HttpStatus.ACCEPTED);
	}	
	
	
//delete comments
	
	@DeleteMapping("/{commentsId}")
	public ResponseEntity<Object> deleteCommentByUser(@PathVariable String commentsId,Principal principal) throws Exception {

		commentService.deleteCommentByUser(commentsId,principal.getName());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} 
}
