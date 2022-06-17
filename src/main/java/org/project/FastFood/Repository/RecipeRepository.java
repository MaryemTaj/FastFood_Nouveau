package org.project.FastFood.Repository;

import org.project.FastFood.Entity.RecipeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository  extends JpaRepository<RecipeEntity, Long>  {
	RecipeEntity findByRecipeId(String recipeId);
	@Query("select r FROM RecipeEntity r inner join r.categorie c inner join r.user u where c.catId = :idCategorie")
	Page<RecipeEntity> findByCategorie(Pageable pageableRequest,@Param("idCategorie") String id_cat);
	@Query("select r FROM RecipeEntity r inner join r.categorie c inner join r.user u where u.userId = :idUser")
	Page<RecipeEntity> findByUser(Pageable pageableRequest, @Param("idUser")String user_id);
    
	RecipeEntity findByName(String name);
    

}
