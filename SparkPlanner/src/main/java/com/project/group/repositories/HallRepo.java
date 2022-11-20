package com.project.group.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.group.models.Hall;
import com.project.group.models.User;



public interface HallRepo extends CrudRepository<Hall, Long>{
	List<Hall> findAll();
	
	Hall findByIdIs(Long id);
	List<User> findAllByUsers(User user);
	List<User> findByUsersNotContains(User user);
//	List<User> findByCreatedOrderIdIs(Long id);
	
}
