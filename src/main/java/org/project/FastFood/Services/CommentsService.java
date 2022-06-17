package org.project.FastFood.Services;

import java.util.List;

import org.project.FastFood.dto.CommentsDto;

public interface CommentsService {
	
	CommentsDto AddComments(CommentsDto comment,String email);
	List<CommentsDto> getComments(int page, int limit, String search, int status, String recipeId);
    void deleteCommentByUser(String commentsId,String email) throws Exception;
	CommentsDto updateComments(CommentsDto comment, String email);
	//CommentsDto updateComments(String CommentId, CommentsDto comment, String email);
}
