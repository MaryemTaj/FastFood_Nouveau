package org.project.FastFood.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.project.FastFood.Request.UserRequest;
import org.project.FastFood.Response.UserResponse;
import org.project.FastFood.Services.UserService;
import org.project.FastFood.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	//api get all users

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UserResponse>> getAllUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "4") int limit,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "status", defaultValue = "1") int status) {

		List<UserResponse> usersResponse = new ArrayList<>();

		List<UserDto> users = userService.getUsers(page, limit, search, status);

		for (UserDto userDto : users) {

			ModelMapper modelMapper = new ModelMapper();
			UserResponse userResponse = modelMapper.map(userDto, UserResponse.class);

			usersResponse.add(userResponse);
		}

		return new ResponseEntity<List<UserResponse>>(usersResponse, HttpStatus.OK);
	}

	//api create user
	 

	@PostMapping("/add")
	public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userR) throws Exception {
		// if(userR.getEmail().isEmpty()) throw new
		// Exception(ErrorMessage.MISSING_REQUIRED_FIELD.getErrorMessage());
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userR, UserDto.class);
		UserDto createUser = userService.createUser(userDto);
		UserResponse userResponse = modelMapper.map(createUser, UserResponse.class);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
	}

	//api get users by id


	@GetMapping("/{id_user}")
	public ResponseEntity<UserResponse> getUser(@PathVariable String id_user) {

		UserDto userDto = userService.getUserbyId(id_user);
		
		UserResponse userResponse = new UserResponse();
		
		BeanUtils.copyProperties(userDto, userResponse);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);

	}

	//api update user
	 

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userRequest, userDto);

		UserDto updateUser = userService.updateUser(id, userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(updateUser, userResponse);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
	}

	// api delete user

	@DeleteMapping("/{id_user}")

	public ResponseEntity<Object> deleteUser(@PathVariable String id_user) {

		userService.deleteUser(id_user);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
