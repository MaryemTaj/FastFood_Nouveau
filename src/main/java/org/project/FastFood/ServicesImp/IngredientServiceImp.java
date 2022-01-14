package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.IngredientEntity;
import org.project.FastFood.Entity.RecipeEntity;
import org.project.FastFood.Repository.IngredientRepository;
import org.project.FastFood.Repository.RecipeRepository;
import org.project.FastFood.Services.IngredientService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.IngredientDto;
import org.project.FastFood.dto.RecipeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImp implements IngredientService {

	@Autowired
	IngredientRepository ingredientRepository;
	@Autowired
	RecipeRepository recipeRepository;
	@Autowired
	Utils util;

//Add Ingredient
	@Override
	public IngredientDto addIngredient(IngredientDto Ingredient, String id_recipe) {

		RecipeEntity recipe = recipeRepository.findByRecipeId(id_recipe);

		ModelMapper modelMapper = new ModelMapper();

		RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);
		Ingredient.setRecipe(recipeDto);
		Ingredient.setIngredientId(util.generateStringId(32));
		IngredientEntity ingredientEntity = modelMapper.map(Ingredient, IngredientEntity.class);
		IngredientEntity newIngredient = ingredientRepository.save(ingredientEntity);
		IngredientDto ingredientDto = modelMapper.map(newIngredient, IngredientDto.class);
		return ingredientDto;
	}

//get Ingredient By Id 
	@Override
	public IngredientDto getIngredientbyId(String ingredientId) {
		IngredientEntity ingredientEntity = ingredientRepository.findByIngredientId(ingredientId);
		if (ingredientEntity == null)
			throw new UsernameNotFoundException(ingredientId);
		IngredientDto ingredientDto = new IngredientDto();
		BeanUtils.copyProperties(ingredientEntity, ingredientDto);
		return ingredientDto;
	}

//Get Ingredient By Recipe	
	@Override
	public List<IngredientDto> getIngredientbyRecipe(String recipeId) {
		List<IngredientDto> ingredientDto = new ArrayList<>();
		List<IngredientEntity> ingredients = ingredientRepository.findByRecipe(recipeId);

		if (ingredients == null)
			throw new UsernameNotFoundException(recipeId);
		for (IngredientEntity ingredientsEntity : ingredients) {

			ModelMapper modelMapper = new ModelMapper();
			IngredientDto ingre = modelMapper.map(ingredientsEntity, IngredientDto.class);

			ingredientDto.add(ingre);
		}
		return ingredientDto;
	}

//Update ingredient of a recipe	
	@Override
	public IngredientDto updateIngredient(String id_ingredient, IngredientDto ingredientDto) {
		IngredientEntity ingredientEntity = ingredientRepository.findByIngredientId(id_ingredient);
		ingredientEntity.setDescription(ingredientDto.getDescription());
		ingredientEntity.setImage(ingredientDto.getImage());
		ingredientEntity.setMeasure_type(ingredientDto.getMeasure_type());
		ingredientEntity.setName(ingredientDto.getName());
		ingredientEntity.setQuantity(ingredientDto.getQuantity());
		IngredientEntity ingreUpdated = ingredientRepository.save(ingredientEntity);
		IngredientDto ingredient = new IngredientDto();
		BeanUtils.copyProperties(ingreUpdated, ingredient);

		return ingredient;
	}

}
