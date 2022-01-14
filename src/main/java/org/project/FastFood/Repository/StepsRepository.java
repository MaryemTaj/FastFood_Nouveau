package org.project.FastFood.Repository;

import java.util.List;

import org.project.FastFood.Entity.StepsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StepsRepository extends JpaRepository<StepsEntity, Long> {

	StepsEntity findByStepId(String stepsId);
	@Query("select s FROM StepsEntity s inner join s.recipe r  where r.recipeId = :recipeId")
	List<StepsEntity> findByRecipe(String recipeId);


}
