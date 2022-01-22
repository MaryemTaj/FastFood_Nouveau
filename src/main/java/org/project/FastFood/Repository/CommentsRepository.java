package org.project.FastFood.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.project.FastFood.Entity.CommentsEntity;
@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity,Long>{
    @Query("select c from CommentsEntity c inner join c.recipe r inner join c.user u where r.recipeId=:recipeId")
	Page<CommentsEntity> findByRecipe(Pageable pageableRequest, String recipeId);
    
    CommentsEntity findByCommentId(String commentId);
    
    @Query("select c from CommentsEntity c inner join c.recipe r inner join c.user u where c.commentId=:commentId and u.email=:email")
	CommentsEntity findByCommentIdAndUser(String commentId,String email);
}
