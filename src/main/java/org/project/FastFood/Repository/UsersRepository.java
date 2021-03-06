package org.project.FastFood.Repository;

import java.util.Optional;
import java.util.Set;

import org.project.FastFood.Entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends PagingAndSortingRepository<UserEntity, Long> {

	@Query("SELECT user FROM UserEntity user")
	Page<UserEntity> findAllUsers(Pageable pageableRequest);	
	UserEntity findByUserId(String userId);
    UserEntity findByEmail(String email);
    UserEntity findByEmailOrUsername(String email,String username);
	Optional<UserEntity> findByUsernameOrEmail(String username, String email);
	@Query("SELECT u FROM UserEntity u  left join u.reactions re left join re.recipe r where r.recipeId=:recipeId and re.emoji=:emoji")	
	Page<UserEntity> findAllUsersByReactionEmojiAndRecipe(Pageable pageableRequest, String recipeId,String emoji);
	@Query("SELECT count(u) FROM UserEntity u  left join u.reactions re left join re.recipe r where r.recipeId=:recipeId and re.emoji=:emoji")	
	int countAllUsersByReactionEmojiAndRecipe( String recipeId,String emoji);
	Optional<UserEntity> findByUsername(String username);
	@Query("SELECT u FROM UserEntity u  inner join u.roles ro  where u.userId=:userId and ro.name=:name")	
	UserEntity findByUserIdAndRoles(String userId,Set<String> name);
	
	
	

	
}
