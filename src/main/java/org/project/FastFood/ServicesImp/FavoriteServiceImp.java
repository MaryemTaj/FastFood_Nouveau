package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.FavoriteEntity;
import org.project.FastFood.Entity.RecipeEntity;
import org.project.FastFood.Entity.UserEntity;
import org.project.FastFood.Repository.FavoriteRepository;
import org.project.FastFood.Repository.RecipeRepository;
import org.project.FastFood.Repository.UsersRepository;
import org.project.FastFood.Response.ErrorMessage;
import org.project.FastFood.Services.FavoriteService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.FavoriteDto;
import org.project.FastFood.dto.RecipeDto;
import org.project.FastFood.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public FavoriteDto addRecipeToFavorite1(String recipeId,String email) {
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
		favoriteDto.setFavId(util.generateStringId(32));
	    FavoriteEntity favoriteEntity =modelMapper.map(favoriteDto, FavoriteEntity.class);
	    FavoriteEntity saveFavorite = favoriteRepository.save(favoriteEntity); 
	    FavoriteDto favorite = modelMapper.map(saveFavorite, FavoriteDto.class);
	    return favorite;
	}

	
	@Override
	public FavoriteDto addRecipeToFavorite2(String email,String recipeId) {
		//if already favorite
		FavoriteEntity searchFavorite = favoriteRepository.findByUserAndRecipe(recipeId,email);
		if(searchFavorite != null) throw new RuntimeException(" Already Favorite !");
		FavoriteDto favoriteDto =new FavoriteDto();
		ModelMapper modelMapper=new ModelMapper();
		/*modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);*/
		//get user 
	    UserEntity currentUser = userRepository.findByEmail(email);					
		UserDto userDto = modelMapper.map(currentUser, UserDto.class);
		//get recipe
		RecipeEntity recipeEntity = recipeRepository.findByRecipeId(recipeId);
		RecipeDto recipeDto = modelMapper.map(recipeEntity,RecipeDto.class);
	    favoriteDto.setUser(userDto);
	    favoriteDto.setRecipe(recipeDto);
		favoriteDto.setFavId(util.generateStringId(32));
	    FavoriteEntity favoriteEntity =modelMapper.map(favoriteDto, FavoriteEntity.class);
	    FavoriteEntity saveFavorite = favoriteRepository.save(favoriteEntity); 
	    FavoriteDto favorite = modelMapper.map(saveFavorite, FavoriteDto.class);
	    return favorite;
	}
	
	
//get favorite recipe of user
	
	@Override
	public List<FavoriteDto> getFavoriteByUser(int page, int limit, String search, int status,String email) {
	
		
					if(page > 0) page = page - 1;
					
					List<FavoriteDto> favoriteDto = new ArrayList<>();
					
					Pageable pageableRequest = PageRequest.of(page, limit);
					
					Page<FavoriteEntity> favoritePage;		
					favoritePage =favoriteRepository.findByUser(pageableRequest,email);				
					List<FavoriteEntity> favorites = favoritePage.getContent();
					
					for(FavoriteEntity favoriteEntity: favorites) {
						
						ModelMapper modelMapper = new ModelMapper();	
						FavoriteDto recipe = modelMapper.map(favoriteEntity, FavoriteDto.class);
						favoriteDto.add(recipe);						
					}		
					return favoriteDto;
				}
	
//delete favorite	
	
	@Override
	public void deleteFavorite(String favId) throws Exception {
		
		FavoriteEntity favEntity = favoriteRepository.findByFavId(favId);
		if(favEntity == null) throw new Exception(ErrorMessage.NO_RECORD_FOUND.getErrorMessage());
		favoriteRepository.delete(favEntity);			
	}
}
