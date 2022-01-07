package org.project.FastFood.Services;

import java.util.List;

import org.project.FastFood.dto.RecipeDto;
import org.project.FastFood.dto.UserDto;




public interface RecipeService {


	List<RecipeDto> getRecipesByCategorie(int page, int limit, String search, int status, long id_cat);

	//RecipeDto updateRecipe(String id_recipe, RecipeDto recipeDto);
	//RecipeDto PostRecipe(RecipeDto recipe, long id);

	//RecipeDto PostRecipe(RecipeDto recipe);

	RecipeDto PostRecipe(RecipeDto recipe);
	 
	List<RecipeDto> getRecipeByUser(int page, int limit, String search, int status, String user_id);

	//RecipeDto updateRecipe(long id_recipe, RecipeDto recipeDto);
	

}
