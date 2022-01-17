package org.project.FastFood.Controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Response.FavoriteResponse;
import org.project.FastFood.Services.FavoriteService;
import org.project.FastFood.dto.FavoriteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/favorite")
@RestController
public class FovoriteController {
	@Autowired
	FavoriteService favoriteService ;
	
	@PostMapping	
	ResponseEntity<FavoriteResponse> addMyfavorite(@RequestParam String recipeId ,Principal principal) throws Exception{		
		FavoriteDto favoriteDto = favoriteService.addFavorite( recipeId,principal.getName());
		ModelMapper modelMapper = new ModelMapper();
		FavoriteResponse favoriteResponse = modelMapper.map(favoriteDto, FavoriteResponse.class);
		
		return new ResponseEntity<>(favoriteResponse,HttpStatus.CREATED);
	}

}
