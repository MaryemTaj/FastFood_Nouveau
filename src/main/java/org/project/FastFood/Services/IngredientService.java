package org.project.FastFood.Services;

import java.util.List;

import org.project.FastFood.dto.IngredientDto;


public interface IngredientService {
	IngredientDto addIngredient(IngredientDto ingDto, String RecipeId);

	IngredientDto getIngredientbyId(String ingredientId);

	List<IngredientDto> getIngredientbyRecipe(String recipeId);

	IngredientDto updateIngredient(String id, IngredientDto ingredientDto);

	//void deleteStep(String IngredientId);
}
