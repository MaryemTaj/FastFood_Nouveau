package org.project.FastFood.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.FastFood.Request.RecipeRequest;
import org.project.FastFood.Response.RecipeResponse;
import org.project.FastFood.Services.RecipeService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.RecipeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	@Autowired
	RecipeService recipeService;
	@Autowired
	Utils util;

	//api get recipe by categorie
	 

	@GetMapping("/categorie/{id_cat}")
	public ResponseEntity<List<RecipeResponse>> getRecipesByCategorie(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "4") int limit,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "status", defaultValue = "1") int status, @PathVariable String id_cat) {

		List<RecipeResponse> recipesResponse = new ArrayList<>();
		List<RecipeDto> recipes = recipeService.getRecipesByCategorie(page, limit, search, status, id_cat);

		for (RecipeDto recipeDto : recipes) {

			ModelMapper modelMapper = new ModelMapper();
			RecipeResponse recipeResponse = modelMapper.map(recipeDto, RecipeResponse.class);

			recipesResponse.add(recipeResponse);
		}

		return new ResponseEntity<List<RecipeResponse>>(recipesResponse, HttpStatus.OK);

	}

	//api ajouter recipe
	
	@PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RecipeResponse> postRecipe(@RequestBody RecipeRequest recipeR, Principal principal) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);
		RecipeDto recipeDto = modelMapper.map(recipeR, RecipeDto.class);

		RecipeDto createRecipe = recipeService.PostRecipe(recipeDto, principal.getName());

		RecipeResponse recipeResponse = modelMapper.map(createRecipe, RecipeResponse.class);

		return new ResponseEntity<RecipeResponse>(recipeResponse, HttpStatus.CREATED);
	}

	
	//api get recipe by id user
	
	@GetMapping("/user/{id_user}")
	public ResponseEntity<List<RecipeResponse>> getRecipesByUser(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "4") int limit,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "status", defaultValue = "1") int status, @PathVariable String id_user) {

		List<RecipeResponse> recipesResponse = new ArrayList<>();

		List<RecipeDto> recipes = recipeService.getRecipeByUser(page, limit, search, status, id_user);

		for (RecipeDto recipeDto : recipes) {

			ModelMapper modelMapper = new ModelMapper();
			RecipeResponse recipeResponse = modelMapper.map(recipeDto, RecipeResponse.class);

			recipesResponse.add(recipeResponse);
		}

		return new ResponseEntity<List<RecipeResponse>>(recipesResponse, HttpStatus.OK);

	}

	// api update recipe

	@PutMapping("/{id_recipe}")
	public ResponseEntity<RecipeResponse> UpdateUser(
			@PathVariable String id_recipe,
			@RequestBody RecipeRequest recipeRequest) {
	
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);
	    RecipeDto recipe = modelMapper.map(recipeRequest, RecipeDto.class);		
		RecipeDto updateRecipe = recipeService.updateRecipe(id_recipe, recipe);
		RecipeResponse recipeResponse = new RecipeResponse();
		BeanUtils.copyProperties(updateRecipe, recipeResponse);
		return new ResponseEntity<RecipeResponse>(recipeResponse, HttpStatus.ACCEPTED);
	}

	//api get recipe by id


	@GetMapping("/{id_recipe}")
	public ResponseEntity<RecipeResponse> getUser(@PathVariable String id_recipe) {
		RecipeDto recipeDto = recipeService.getRecipebyId(id_recipe);
		RecipeResponse recipeResponse = new RecipeResponse();
		 ModelMapper modelMapper = new ModelMapper();
		    modelMapper.getConfiguration()
	        .setMatchingStrategy(MatchingStrategies.STRICT);
		    RecipeResponse recipeRes = modelMapper.map(recipeDto,RecipeResponse.class);
		//BeanUtils.copyProperties(recipeDto, recipeResponse);
		return new ResponseEntity<RecipeResponse>(recipeRes, HttpStatus.OK);

	}

}
