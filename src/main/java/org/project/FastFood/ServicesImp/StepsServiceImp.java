package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.RecipeEntity;
import org.project.FastFood.Entity.StepsEntity;
import org.project.FastFood.Exception.UserException;
import org.project.FastFood.Repository.RecipeRepository;
import org.project.FastFood.Repository.StepsRepository;
import org.project.FastFood.Response.ErrorMessage;
import org.project.FastFood.Services.StepsService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.RecipeDto;
import org.project.FastFood.dto.StepsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StepsServiceImp implements StepsService {
	
	@Autowired 
	StepsRepository stepsRepository;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	Utils util;
	
// Add steps
	
	@Override
	public StepsDto addSteps(StepsDto steps,String id_recipe) {	
		
    RecipeEntity recipe = recipeRepository.findByRecipeId(id_recipe);
		   
    ModelMapper modelMapper = new ModelMapper();
    
    RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);	
	
	steps.setRecipe(recipeDto);
	steps.setStepId(util.generateStringId(32));;
	StepsEntity stepsEntity = modelMapper.map(steps,StepsEntity.class);
	StepsEntity newSteps = stepsRepository.save(stepsEntity);	
	StepsDto stepsDto =  modelMapper.map(newSteps, StepsDto.class);
	
	return stepsDto;

}
	
	
//get steps  by id steps
	
	@Override
	public StepsDto getStepsbyId(String stepsId) {
		 StepsEntity stepsEntity = stepsRepository.findByStepId(stepsId);
		    if(stepsEntity == null) throw new UserException(ErrorMessage.NO_RECORD_FOUND.getErrorMessage());
		    StepsDto stepsDto = new StepsDto();
		    BeanUtils.copyProperties(stepsEntity, stepsDto);
		    return stepsDto;
	}
	
	
//get steps  by recipe
	
		@Override
		public List<StepsDto> getStepsbyRecipe(String recipeId) {
			   List<StepsDto> stepsDto = new ArrayList<>();
			   List<StepsEntity> steps= stepsRepository.findByRecipe(recipeId);
			   
				
			    if(steps == null) throw new UsernameNotFoundException(recipeId); 
			    for(StepsEntity stepsEntity: steps) {
					
					ModelMapper modelMapper = new ModelMapper();	
					StepsDto step = modelMapper.map(stepsEntity, StepsDto.class);
					
					stepsDto.add(step);
				}				  
			    return stepsDto;
		}
//Update steps of a recipe	
		
		@Override
		public StepsDto updateStep(String id, StepsDto stepsDto) {
			
				StepsEntity stepEntity = stepsRepository.findByStepId(id);
				stepEntity.setDescription(stepsDto.getDescription());
				stepEntity.setImage(stepsDto.getImage());	
				stepEntity.setNumber_step(stepsDto.getNumber_step());
				StepsEntity stepUpdated =stepsRepository.save(stepEntity);	
				StepsDto step = new StepsDto();
				BeanUtils.copyProperties(stepUpdated, step);
					
				return step;
			}
		
		
//delete user
		
		@Override
		public void deleteStep(String stepId) {
						
				StepsEntity stepEntity = stepsRepository.findByStepId(stepId);	
				if(stepEntity == null) throw new UsernameNotFoundException(stepId); 		
				stepsRepository.delete(stepEntity);			
			
		}

}



