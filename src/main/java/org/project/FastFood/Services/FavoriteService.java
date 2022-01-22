package org.project.FastFood.Services;

import java.util.List;

import org.project.FastFood.dto.FavoriteDto;


public interface FavoriteService {
	
	

	//Ajouter favorite methode 2
	FavoriteDto addRecipeToFavorite2(String email, String recipeId);
	//Ajouter favorite methode 1
    FavoriteDto addRecipeToFavorite1(String recipeId, String email);
		
	List<FavoriteDto> getFavoriteByUser(int page, int limit, String search, int status, String email);
	
	void deleteFavorite(String favId) throws Exception;
	

 
}
