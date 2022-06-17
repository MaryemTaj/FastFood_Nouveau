package org.project.FastFood.Repository;



import org.project.FastFood.Entity.ReactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<ReactionEntity, Long> {

	@Query("Select re from ReactionEntity re inner join re.recipe r inner join re.user u where r.recipeId=:recipeId and u.email = :email ")
	ReactionEntity FindByRecipeAndUser(String recipeId, String email);
	@Query("Select re from ReactionEntity re inner join re.recipe r inner join re.user u  where u.email = :email ")
	Page<ReactionEntity> findByUser(Pageable pageableRequest,String email);
	@Query("Select re from ReactionEntity re inner join re.recipe r inner join re.user u where r.recipeId=:recipeId  ")
	Page<ReactionEntity> findByRecipe(Pageable pageableRequest, String recipeId);
	@Query("Select count(re) from ReactionEntity re inner join re.recipe r inner join re.user u where r.recipeId=:recipeId  ")
	int countByRecipe(String recipeId);	
	@Query
	ReactionEntity findByReactionId(String reactionId);
	@Query("Select re from ReactionEntity re inner join re.user u inner join re.recipe r where u.email=:email and re.reactionId=:reactionId ")
	ReactionEntity findByReactionIdAndUser(String reactionId, String email);
}
