package org.project.FastFood.Services;


import java.util.List;

import org.project.FastFood.dto.StepsDto;


public interface StepsService {
	StepsDto addSteps(StepsDto steps, String id_rcipe);
	StepsDto getStepsbyId(String stepsId);
	List<StepsDto> getStepsbyRecipe(String recipeId);
	StepsDto updateStep(String id, StepsDto stepsDto);
	void deleteStep(String stepsId);
	
	
	
}
