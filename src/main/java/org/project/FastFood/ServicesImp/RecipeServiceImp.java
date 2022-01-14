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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	
	
//methode get recipe by categorie	
    @Override
	public List<RecipeDto> getRecipesByCategorie(int page, int limit, String search, int status,String id_cat ){
					
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
			recipe.setRecipId(util.generateStringId(32));
			RecipeEntity recipeEntity = modelMapper.map(recipe, RecipeEntity.class); 
			RecipeEntity newRecipe = recipeRepository.save(recipeEntity);
			
			RecipeDto recipeDto =  modelMapper.map(newRecipe,RecipeDto.class);
			
			return recipeDto;		
	}
	
//get recipes of user	
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
	
	

	//update recipe(not working yet) 
	@Override
	public RecipeDto updateRecipe(String id_recipe,RecipeDto recipeDto) {
	   CategorieEntity categorie = categorieRepository.findByName(recipeDto.getCategorie().getName());
		ModelMapper modelMapper = new ModelMapper();
		CategorieDto categorieDto = modelMapper.map(categorie, CategorieDto.class);	
		recipeDto.setCategorie(categorieDto);
		CategorieEntity newCat = modelMapper.map(categorieDto, CategorieEntity.class);
		RecipeEntity recipeEntity = recipeRepository.findByRecipeId(id_recipe);
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
		recipeEntity.setCategorie(newCat);
		RecipeEntity recipeUpdated = recipeRepository.save(recipeEntity);
        RecipeDto recipeDt = new RecipeDto();
		BeanUtils.copyProperties(recipeUpdated, recipeDt);
		return recipeDt;		
	}
	
	
	//methode get recipe by id	
		@Override
		public RecipeDto getRecipebyId(String recipeId){			
		    RecipeEntity recipeEntity = recipeRepository.findByRecipeId(recipeId);
		    if(recipeEntity == null) throw new UsernameNotFoundException(recipeId); 
		    RecipeDto recipeDto = new RecipeDto();
		    BeanUtils.copyProperties(recipeEntity, recipeDto);
		    return recipeDto;
		}
}


