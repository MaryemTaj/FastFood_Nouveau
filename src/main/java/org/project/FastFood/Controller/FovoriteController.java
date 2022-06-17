package org.project.FastFood.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.FastFood.Request.RecipeRequest;
import org.project.FastFood.Response.FavoriteResponse;
import org.project.FastFood.Services.FavoriteService;
import org.project.FastFood.dto.FavoriteDto;
import org.project.FastFood.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/favorite")
@RestController
public class FovoriteController {
	@Autowired
	FavoriteService favoriteService ;
	
	
	//add recipe to favorite methode 1
	@PostMapping	
	ResponseEntity<FavoriteResponse> addMyfavorite1(@RequestParam String recipeId ,Principal principal) throws Exception{
		
		FavoriteDto favoriteDto = favoriteService.addRecipeToFavorite1( recipeId,principal.getName());
		
		ModelMapper modelMapper = new ModelMapper();
		
		FavoriteResponse favoriteResponse = modelMapper.map(favoriteDto, FavoriteResponse.class);
		
		return new ResponseEntity<>(favoriteResponse,HttpStatus.CREATED);
	}
	
	//add recipe to favorite methode 2
	@PostMapping("/add")	
	ResponseEntity<FavoriteResponse> addMyfavorite2(Principal principal,@RequestBody RecipeRequest recipe) throws Exception{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);
		RecipeDto recipeR= modelMapper.map(recipe, RecipeDto.class);
		FavoriteDto favoriteDto = favoriteService.addRecipeToFavorite2(principal.getName(),recipeR.getRecipeId());
		
		FavoriteResponse favoriteResponse = modelMapper.map(favoriteDto, FavoriteResponse.class);
		
		return new ResponseEntity<>(favoriteResponse,HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<FavoriteResponse>> getFavoriteByUser(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "4") int limit,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "status", defaultValue = "1") int status, Principal principal){
		    
		    List<FavoriteResponse> favoritesRecipes = new ArrayList<>();
		
		    List<FavoriteDto> favorites = favoriteService.getFavoriteByUser(page, limit, search,status,principal.getName());
		    
		    for(FavoriteDto favoriteDto : favorites) {
		    	
		    	ModelMapper modelMapper = new ModelMapper();
		    	
		    	FavoriteResponse favoriteResponse = modelMapper.map(favoriteDto, FavoriteResponse.class);
		    	
		    	favoritesRecipes.add(favoriteResponse); 		    	
		    }
		    
			return new ResponseEntity<List<FavoriteResponse>>(favoritesRecipes,HttpStatus.OK);
			
			}

	
	@DeleteMapping("/{id_fav}")

	public ResponseEntity<Object> deleteFavorite(@PathVariable String id_fav) throws Exception {
		favoriteService.deleteFavorite(id_fav);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
}
