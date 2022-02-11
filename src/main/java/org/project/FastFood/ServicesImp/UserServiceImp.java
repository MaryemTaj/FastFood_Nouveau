package org.project.FastFood.ServicesImp;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.project.FastFood.Repository.RoleRepository;
import org.project.FastFood.Repository.UsersRepository;
import org.project.FastFood.Services.UserService;
import org.project.FastFood.Util.ERole;
import org.project.FastFood.Util.Utils;

import org.project.FastFood.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.RoleEntity;
import org.project.FastFood.Entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





@Service
public class UserServiceImp implements UserService {
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	Utils util;
	
   

//login
	
	  @Override
	  @Transactional
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    UserEntity user = userRepository.findByEmail(email);
	    if( user == null) throw new RuntimeException("User Not Found with email: " + email);
	      

	    return UserDetailsImpl.build(user);
	  }
	
	
	
	
	
// methode create new users(signup users)
	  
	    @Override
        public UserDto createUser(UserDto user) {
	    	
	    	UserEntity UserChercher = userRepository.findByEmail(user.getEmail());
			
		if( UserChercher != null) throw new RuntimeException("User Already Exists !");
		
		  //get role user
		   Set<RoleEntity> roles = new HashSet<>();
			      RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
			          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			      roles.add(userRole);
			    
		
	    ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(user, UserEntity.class); 
		userEntity.setCryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(util.generateStringId(32));;
		userEntity.setRoles(roles);
		
		UserEntity newUser = userRepository.save(userEntity);
		
		UserDto userDto =  modelMapper.map(newUser, UserDto.class);
		
		return userDto;	
	 
 }
//add users with roles by admin	 
	    
	    @Override
        public UserDto AddUserByAdmin(UserDto user) {
	    	
	    UserEntity UserChercher = userRepository.findByEmail(user.getEmail());
			
		if( UserChercher != null) throw new RuntimeException("User Already Exists !");
		
	    ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(user, UserEntity.class); 
		userEntity.setCryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(util.generateStringId(32));;
	
		Set<String> strRoles = user.getRoles();
	    Set<RoleEntity> roles = new HashSet<>();

        //get roles
	    if (strRoles == null) {
	        RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
	            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	        roles.add(userRole);
	      } else {
	        strRoles.forEach(role -> {
	          switch (role) {
	          case "admin":
	            RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	            roles.add(adminRole);

	            break;
	          case "manager":
	            RoleEntity modRole = roleRepository.findByName(ERole.ROLE_MANAGER)
	                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	            roles.add(modRole);

	            break;
	          case "user":
		            RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
		                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		            roles.add(userRole);

		            break;
		       
	          default:
		            RoleEntity defaultRole = roleRepository.findByName(ERole.ROLE_MANAGER)
		                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		            roles.add(defaultRole);

		            break;    
	         
	          }
	        });
	      }
		
		//to set roles
	    
	  	userEntity.setRoles(roles);
		UserEntity newUser = userRepository.save(userEntity);
		
		UserDto userDto =  modelMapper.map(newUser, UserDto.class);
		
		return userDto;
		
			 
 }
	    
//	update role by admin 
	    
	    @Override
		public UserDto updateRole(String userId, UserDto userDto) {

			UserEntity userEntity = userRepository.findByUserId(userId);

			if (userEntity == null)
				throw new UsernameNotFoundException(userId);
			/*String role = userDto.getRole();
		    String roleAdmin = "ADMIN";
		    String roleUser = "USER";
		    
			if((role.equals(roleAdmin) == false) && (role.equals(roleUser) == false) ) throw new RuntimeException("vous devez entrer un role valide (admin ou user) !");
			userEntity.setRole(role);*/
			

			Set<String> strRoles = userDto.getRoles();
		    Set<RoleEntity> roles = new HashSet<>();
			if (strRoles == null) {
		        RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
		            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		        roles.add(userRole);
		      } else {
		        strRoles.forEach(role -> {
		          switch (role) {
		          case "admin":
		            RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
		                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		            roles.add(adminRole);

		            break;
		          case "manager":
		            RoleEntity modRole = roleRepository.findByName(ERole.ROLE_MANAGER)
		                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		            roles.add(modRole);

		            break;
		          case "user":
			            RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
			                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			            roles.add(userRole);

			            break;
			       
		          default:
			            RoleEntity defaultRole = roleRepository.findByName(ERole.ROLE_USER)
			                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			            roles.add(defaultRole);

			            break;    
		         
		          }
		        });
		      }
			userEntity.setRoles(roles);
			UserEntity userUpdateRole = userRepository.save(userEntity);
            ModelMapper modelMapper = new ModelMapper();
			
			UserDto newUserDto =  modelMapper.map(userUpdateRole, UserDto.class);

			

			return newUserDto;
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
	public UserDto getUserbyId(String userId){
		
	    UserEntity userEntity = userRepository.findByUserId(userId);
	    if(userEntity == null) throw new UsernameNotFoundException(userId); 
	    UserDto userDto = new UserDto();
	    BeanUtils.copyProperties(userEntity, userDto);
	    return userDto;
	}
	
//methode update user	

	@Override
	public UserDto updateUser(String userId, UserDto userDto) {

		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException(userId);

		userEntity.setFirstname(userDto.getFirstname());
		userEntity.setLastname(userDto.getLastname());
		userEntity.setPhone(userDto.getPhone());
		userEntity.setImage(userDto.getImage());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setUsername(userDto.getUsername());

		UserEntity userUpdated = userRepository.save(userEntity);

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
	/*@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByUsernameOrEmail(email, email) .orElseThrow(() ->
        new UsernameNotFoundException("User not found with username or email:" + email));
	       
		
		if(userEntity == null) throw new UsernameNotFoundException(email); 
		
	
		return new User(userEntity.getEmail(), userEntity.getCryptedPassword(), getAuthorities(userEntity));
		
	}
	*/
	
	
	
	    
//find user by email
	
	@Override
	public UserDto getUser(String email) {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email); 
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userEntity, userDto);
		
		return userDto;
	}

}

	
	
	
	
	


