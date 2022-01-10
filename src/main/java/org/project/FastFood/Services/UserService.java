package org.project.FastFood.Services;

import java.util.List;


import org.project.FastFood.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService  {


	UserDto createUser(UserDto user);
	List<UserDto> getUsers(int page, int limit, String search, int status);
	UserDto getUserbyId(String id_user);
	UserDto updateUser(String id_user, UserDto userDto);
	void deleteUser(String userId);
	UserDetails loadUserByUsername(String email) ;
	UserDto getUser(String userName);

	
	
}

