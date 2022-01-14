package org.project.FastFood.Repository;

import java.util.List;

import org.project.FastFood.Entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

	IngredientEntity findByIngredientId(String ingredientId);
	@Query("select i FROM IngredientEntity i inner join i.recipe r  where r.recipeId = :recipeId")
	List<IngredientEntity> findByRecipe(String recipeId);

}
