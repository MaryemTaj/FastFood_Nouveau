package org.project.FastFood.ServicesImp;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.FavoriteEntity;
import org.project.FastFood.Entity.RecipeEntity;
import org.project.FastFood.Entity.UserEntity;
import org.project.FastFood.Repository.FavoriteRepository;
import org.project.FastFood.Repository.RecipeRepository;
import org.project.FastFood.Repository.UsersRepository;
import org.project.FastFood.Services.FavoriteService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.FavoriteDto;
import org.project.FastFood.dto.RecipeDto;
import org.project.FastFood.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FavoriteServiceImp  implements FavoriteService {
@Autowired
UsersRepository userRepository;
@Autowired
RecipeRepository recipeRepository;
@Autowired
FavoriteRepository favoriteRepository;
@Autowired
Utils util;

//add recipe to  favorite
	@Override
	public FavoriteDto addFavorite(String recipeId,String email) {
		//if already favorite
		FavoriteEntity searchFavorite = favoriteRepository.findByUserAndRecipe(recipeId,email);
		if(searchFavorite != null) throw new RuntimeException(" Already Favorite !");
		FavoriteDto favoriteDto =new FavoriteDto();
		ModelMapper modelMapper=new ModelMapper();
		//get user 
	    UserEntity currentUser = userRepository.findByEmail(email);					
		UserDto userDto = modelMapper.map(currentUser, UserDto.class);
		//get recipe
		RecipeEntity recipe = recipeRepository.findByRecipeId(recipeId);
		RecipeDto recipeDto = modelMapper.map(recipe,RecipeDto.class);
	    favoriteDto.setUser(userDto);
	    favoriteDto.setRecipe(recipeDto);
		favoriteDto.setFavoriteId(util.generateStringId(32));
	    FavoriteEntity favoriteEntity =modelMapper.map(favoriteDto, FavoriteEntity.class);
	    FavoriteEntity saveFavorite = favoriteRepository.save(favoriteEntity); 
	    FavoriteDto favorite = modelMapper.map(saveFavorite, FavoriteDto.class);
	    return favorite;
	}
	

}
