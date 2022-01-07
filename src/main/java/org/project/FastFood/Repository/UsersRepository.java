package org.project.FastFood.Repository;

import org.project.FastFood.Entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends PagingAndSortingRepository<UserEntity, Long> {

	@Query("SELECT user FROM UserEntity user")
	Page<UserEntity> findAllUsers(Pageable pageableRequest);	
	UserEntity findByUserId(String userId);
	

	
}
