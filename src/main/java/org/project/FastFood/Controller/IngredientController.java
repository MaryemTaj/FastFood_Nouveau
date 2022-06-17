package org.project.FastFood.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Request.IngredientRequest;
import org.project.FastFood.Response.IngredientResponse;
import org.project.FastFood.Services.IngredientService;
import org.project.FastFood.dto.IngredientDto;
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
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Ingredient")
@RestController
public class IngredientController {

	@Autowired
	IngredientService ingredientService;

	// add ingredient
	@PostMapping("/add/{id_recipe}")
	public ResponseEntity<IngredientResponse> AddSteps(@RequestBody @Valid IngredientRequest ingredientR,
			@PathVariable String id_recipe) throws Exception {

		ModelMapper modelMapper = new ModelMapper();
		IngredientDto ingredientDto = modelMapper.map(ingredientR, IngredientDto.class);
		IngredientDto createIng = ingredientService.addIngredient(ingredientDto, id_recipe);
		IngredientResponse ingredientResponse = modelMapper.map(createIng, IngredientResponse.class);
		return new ResponseEntity<IngredientResponse>(ingredientResponse, HttpStatus.CREATED);
	}

	// get steps by id
	@GetMapping("/{id_ingredient}")
	public ResponseEntity<IngredientResponse> getIngredientById(@PathVariable String id_ingredient) {

		IngredientDto ingredientDto = ingredientService.getIngredientbyId(id_ingredient);
		IngredientResponse ingredientResponse = new IngredientResponse();
		BeanUtils.copyProperties(ingredientDto, ingredientResponse);

		return new ResponseEntity<IngredientResponse>(ingredientResponse, HttpStatus.OK);

	}

	// get steps by id
	@GetMapping("/recipe/{id_recipe}")
	public ResponseEntity<List<IngredientResponse>> getIngredientByRecipe(@PathVariable String id_recipe) {
		List<IngredientResponse> ingredientsResponse = new ArrayList<>();

		List<IngredientDto> steps = ingredientService.getIngredientbyRecipe(id_recipe);

		for (IngredientDto ingredientsDto : steps) {

			ModelMapper modelMapper = new ModelMapper();
			IngredientResponse ingreResponse = modelMapper.map(ingredientsDto, IngredientResponse.class);

			ingredientsResponse.add(ingreResponse);
		}

		return new ResponseEntity<List<IngredientResponse>>(ingredientsResponse, HttpStatus.OK);

	}

	// update steps of recipe
	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<IngredientResponse> updateIngredient(@PathVariable String id,
			@RequestBody IngredientRequest ingredientRequest) {

		IngredientDto ingredientDto = new IngredientDto();

		BeanUtils.copyProperties(ingredientRequest, ingredientDto);

		IngredientDto updateIngre = ingredientService.updateIngredient(id, ingredientDto);

		IngredientResponse ingredientResponse = new IngredientResponse();

		BeanUtils.copyProperties(updateIngre, ingredientResponse);

		return new ResponseEntity<IngredientResponse>(ingredientResponse, HttpStatus.ACCEPTED);
	}
}
