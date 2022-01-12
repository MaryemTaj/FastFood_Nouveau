package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.CategorieEntity;
import org.project.FastFood.Entity.RecipeEntity;
import org.project.FastFood.Entity.UserEntity;
import org.project.FastFood.Repository.CategorieRepository;
import org.project.FastFood.Repository.RecipeRepository;
import org.project.FastFood.Repository.UsersRepository;

import org.project.FastFood.Services.RecipeService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.CategorieDto;
import org.project.FastFood.dto.RecipeDto;
import org.project.FastFood.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImp implements RecipeService {
	@Autowired
	RecipeRepository recipeRepository;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	Utils util;
	
	
//methode get recipe by id	
    @Override
	public List<RecipeDto> getRecipesByCategorie(int page, int limit, String search, int status,long id_cat ){
					
			if(page > 0) page = page - 1;
			
			List<RecipeDto> recipeDto = new ArrayList<>();
			
			Pageable pageableRequest = PageRequest.of(page, limit);
			
			Page<RecipeEntity> recipePage;
			
			
			recipePage = recipeRepository.findByCategorie(pageableRequest, id_cat);
			
			
			
			List<RecipeEntity> recipes = recipePage.getContent();
			
			for(RecipeEntity recipeEntity: recipes) {
				
				ModelMapper modelMapper = new ModelMapper();	
				RecipeDto recipe = modelMapper.map(recipeEntity, RecipeDto.class);
				
				recipeDto.add(recipe);
			}		
			return recipeDto;
		}

//ajouter recipe    
	@Override
	public RecipeDto PostRecipe(RecipeDto recipe,String email) {
		
		    CategorieEntity categorie = categorieRepository.findByName(recipe.getCategorie().getName());
		    ModelMapper modelMapper = new ModelMapper();
		    CategorieDto categorireDto = modelMapper.map(categorie, CategorieDto.class);
		    
		    UserEntity currentUser = userRepository.findByEmail(email);			
			
			UserDto userDto = modelMapper.map(currentUser, UserDto.class);
		    recipe.setUser(userDto);
			recipe.setCategorie(categorireDto);
			RecipeEntity recipeEntity = modelMapper.map(recipe, RecipeEntity.class); 
			RecipeEntity newRecipe = recipeRepository.save(recipeEntity);
			
			RecipeDto recipeDto =  modelMapper.map(newRecipe,RecipeDto.class);
			
			return recipeDto;
		
	}
	
//get recipe of user	
        @Override	
        public List<RecipeDto> getRecipeByUser(int page, int limit, String search, int status, String user_id) {
		if(page > 0) page = page - 1;
		
		List<RecipeDto> recipeDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<RecipeEntity> recipePage;
		
		
		recipePage = recipeRepository.findByUser(pageableRequest, user_id);
		
		
		
		List<RecipeEntity> recipes = recipePage.getContent();
		
		for(RecipeEntity recipeEntity: recipes) {
			
			ModelMapper modelMapper = new ModelMapper();	
			RecipeDto recipe = modelMapper.map(recipeEntity, RecipeDto.class);
			
			recipeDto.add(recipe);
		}		
		return recipeDto;
	}	
	
	

	//update recipe
	/*@Override
	public RecipeDto updateRecipe(long id_recipe,RecipeDto recipeDto) {
		CategorieEntity categorie = categorieRepository.findByName(recipeDto.getCategorie().getName());
		ModelMapper modelMapper = new ModelMapper(id_recipe);
		CategorieDto categorireDto = modelMapper.map(categorie, CategorieDto.class);				
		RecipeEntity recipeEntity = recipeRepository.findById();
		if(recipeEntity == null) throw new UsernameNotFoundException(id_recipe); 
		recipeEntity.setImage(recipeDto.getImage());
		recipeEntity.setServings_numbers(recipeDto.getServings_numbers());
		recipeEntity.setCook_time(recipeDto.getCook_time());
		recipeEntity.setPays(recipeDto.getPays());
		recipeEntity.setPrep_time(recipeDto.getPrep_time());
		recipeEntity.setDescription(recipeDto.getDescription());
		recipeEntity.setTags(recipeDto.getTags());
		recipeEntity.setVideo(recipeDto.getVideo());
		recipeEntity.setDifficulty(recipeDto.getDifficulty());
		recipeEntity.setCategorie(categorireDto.get);
		RecipeEntity recipeUpdated = recipeRepository.save(recipeEntity);
        RecipeDto user = new RecipeDto();
		BeanUtils.copyProperties(recipeUpdated, user);
		return user;
		
	}*/
	
}


