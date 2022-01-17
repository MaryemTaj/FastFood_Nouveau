package org.project.FastFood.Services;

import java.util.List;

import org.project.FastFood.dto.RecipeDto;





public interface RecipeService {


	List<RecipeDto> getRecipesByCategorie(int page, int limit, String search, int status, String id_cat);

	RecipeDto updateRecipe(String id_recipe, RecipeDto recipeDto);
	 
	List<RecipeDto> getRecipeByUser(int page, int limit, String search, int status, String user_id);

	RecipeDto PostRecipe(RecipeDto recipe, String email);

	RecipeDto getRecipebyId(String recipeId);



}
