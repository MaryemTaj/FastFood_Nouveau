package org.project.FastFood.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.project.FastFood.Entity.FavoriteEntity;
@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity,Long>{
	@Query("select f from FavoriteEntity f inner join f.recipe r inner join f.user u where r.recipeId=:recipe and u.email=:email")
	FavoriteEntity findByUserAndRecipe(String recipe,String email);
     @Query("select f from FavoriteEntity f inner join f.recipe r inner join f.user u where u.email=:email")
	Page<FavoriteEntity> findByUser(Pageable pageableRequest, String email);
	FavoriteEntity findByFavId(String favId);

}
