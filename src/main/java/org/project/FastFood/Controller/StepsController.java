package org.project.FastFood.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Request.StepsRequest;
import org.project.FastFood.Response.StepsResponse;
import org.project.FastFood.Services.StepsService;
import org.project.FastFood.dto.StepsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/steps")
public class StepsController {

	@Autowired
	StepsService stepsService;

	// add steps
	@PostMapping("/add/{id_recipe}")
	public ResponseEntity<StepsResponse> AddSteps(@RequestBody @Valid StepsRequest stepsR,
			@PathVariable String id_recipe) throws Exception {

		ModelMapper modelMapper = new ModelMapper();
		StepsDto stepsDto = modelMapper.map(stepsR, StepsDto.class);
		StepsDto createStep = stepsService.addSteps(stepsDto, id_recipe);
		StepsResponse stepsResponse = modelMapper.map(createStep, StepsResponse.class);
		return new ResponseEntity<StepsResponse>(stepsResponse, HttpStatus.CREATED);
	}

	// get steps by id
	@GetMapping("/{id_steps}")
	public ResponseEntity<StepsResponse> getStepsById(@PathVariable String id_steps) {

		StepsDto stepsDto = stepsService.getStepsbyId(id_steps);
		StepsResponse stepsResponse = new StepsResponse();
		BeanUtils.copyProperties(stepsDto, stepsResponse);

		return new ResponseEntity<StepsResponse>(stepsResponse, HttpStatus.OK);

	}

	// get steps by id
	@GetMapping("/recipe/{id_recipe}")
	public ResponseEntity<List<StepsResponse>> getStepsByRecipe(@PathVariable String id_recipe) {
		List<StepsResponse> stepsResponse = new ArrayList<>();

		List<StepsDto> steps = stepsService.getStepsbyRecipe(id_recipe);

		for (StepsDto stepsDto : steps) {

			ModelMapper modelMapper = new ModelMapper();
			StepsResponse stepResponse = modelMapper.map(stepsDto, StepsResponse.class);

			stepsResponse.add(stepResponse);
		}

		return new ResponseEntity<List<StepsResponse>>(stepsResponse, HttpStatus.OK);

	}

	// update steps of recipe
	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StepsResponse> updateStep(@PathVariable String id, @RequestBody StepsRequest stepRequest) {

		StepsDto stepDto = new StepsDto();

		BeanUtils.copyProperties(stepRequest, stepDto);

		StepsDto updateStep = stepsService.updateStep(id, stepDto);

		StepsResponse stepResponse = new StepsResponse();

		BeanUtils.copyProperties(updateStep, stepResponse);

		return new ResponseEntity<StepsResponse>(stepResponse, HttpStatus.ACCEPTED);
	}

	// delete a step
	@DeleteMapping("/{id_step}")

	public ResponseEntity<Object> deleteStep(@PathVariable String id_step) {

		stepsService.deleteStep(id_step);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
