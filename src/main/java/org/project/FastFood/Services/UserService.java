package org.project.FastFood.Services;

import java.util.List;
import org.project.FastFood.dto.UserDto;


public interface UserService {


	UserDto createUser(UserDto user);
	List<UserDto> getUsers(int page, int limit, String search, int status);
	UserDto getUserbyId(String id_user);
	UserDto updateUser(String id_user, UserDto userDto);
	void deleteUser(String userId);
	
	
}

