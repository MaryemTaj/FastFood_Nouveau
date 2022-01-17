package org.project.FastFood.Services;

import org.project.FastFood.dto.FavoriteDto;

public interface FavoriteService {
	FavoriteDto addFavorite(String email, String recipeId);

 
}
