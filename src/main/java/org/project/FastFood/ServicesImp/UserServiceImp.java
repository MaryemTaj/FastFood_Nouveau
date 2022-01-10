package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.project.FastFood.Repository.UsersRepository;
import org.project.FastFood.Services.UserService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.UserDto;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
	
   
	
	
// methode create new users(registration users)
	    @Override
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
 
 
// methode get all users	    
	@Override
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
	
// methode get user by id	
	@Override
	public UserDto getUserbyId(String email){
		
	    UserEntity userEntity = userRepository.findByEmail(email);
	    if(userEntity == null) throw new UsernameNotFoundException(email); 
	    UserDto userDto = new UserDto();
	    BeanUtils.copyProperties(userEntity, userDto);
	    return userDto;
	}
//methode update user	
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

//delete user	
	@Override
	public void deleteUser(String id_user) {
					
			UserEntity userEntity = userRepository.findByUserId(id_user);	
			if(userEntity == null) throw new UsernameNotFoundException(id_user); 		
			userRepository.delete(userEntity);			
		
	}
	
//login user	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByUsernameOrEmail(email, email) .orElseThrow(() ->
        new UsernameNotFoundException("User not found with username or email:" + email));
	       
		
		if(userEntity == null) throw new UsernameNotFoundException(email); 
		
		return new User(userEntity.getEmail(), userEntity.getCryptedPassword(), new ArrayList<>());
	}


//
	@Override
	public UserDto getUser(String email) {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email); 
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userEntity, userDto);
		
		return userDto;
	}


	

}

	
	
	
	
	


