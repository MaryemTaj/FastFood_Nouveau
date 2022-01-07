package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;

import org.project.FastFood.Repository.UsersRepository;
import org.project.FastFood.Services.UserService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImp implements UserService {
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	Utils util;
	
   /* @Autowired
     AuthenticationManager authenticationManager;*/

	@Override
	
	    // methode create new users(registration users)
        public UserDto createUser(UserDto user) {
	 
	    ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(user, UserEntity.class); 
		userEntity.setCryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(util.generateStringId(32));;
		userEntity.setRole("user");
		UserEntity newUser = userRepository.save(userEntity);
		
		UserDto userDto =  modelMapper.map(newUser, UserDto.class);
		
		return userDto;
		
		
	 
 }
 
 
	/*@Override
	    public UserDto authenticateUser(UserDto userDto){
	
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	        userDto.getEmail(), userDto.getPassword()));  
	        SecurityContextHolder.getContext().setAuthentication(authentication);	    	
	        return userDto;
	        
	        
	    }*/

	@Override
	// methode get all users
	public List<UserDto> getUsers(int page, int limit, String search, int status) {
		
		if(page > 0) page = page - 1;
		
		List<UserDto> usersDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<UserEntity> userPage;
		
		
			userPage = userRepository.findAllUsers(pageableRequest);
		
		
		
		List<UserEntity> users = userPage.getContent();
		
		for(UserEntity userEntity: users) {
			
			ModelMapper modelMapper = new ModelMapper();	
			UserDto user = modelMapper.map(userEntity, UserDto.class);
			
			usersDto.add(user);
		}		
		return usersDto;
	}
	
	@Override
	public UserDto getUserbyId(String id_user){
		
	    UserEntity userEntity = userRepository.findByUserId(id_user);
	    if(userEntity == null) throw new UsernameNotFoundException(id_user); 
	    UserDto userDto = new UserDto();
	    BeanUtils.copyProperties(userEntity, userDto);
	    return userDto;
	}
	
	@Override
	public UserDto updateUser(String id_user,UserDto userDto) {
		
		UserEntity userEntity = userRepository.findByUserId(id_user);
		if(userEntity == null) throw new UsernameNotFoundException(id_user); 
		userEntity.setFirstname(userDto.getFirstname());
		userEntity.setLastname(userDto.getLastname());
		userEntity.setPhone(userDto.getPhone());
		userEntity.setImage(userDto.getImage());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setUsername(userDto.getUsername());
		UserEntity userUpdated= userRepository.save(userEntity);
        UserDto user = new UserDto();
		BeanUtils.copyProperties(userUpdated, user);
		return user;
		
		
	}
	
	@Override
	public void deleteUser(String id_user) {
					
			UserEntity userEntity = userRepository.findByUserId(id_user);	
			if(userEntity == null) throw new UsernameNotFoundException(id_user); 		
			userRepository.delete(userEntity);			
		
	}


	

}

	
	
	
	
	


