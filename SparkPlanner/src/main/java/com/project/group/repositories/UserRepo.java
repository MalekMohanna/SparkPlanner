package com.project.group.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.group.models.Hall;
import com.project.group.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	List<User> findAll();
	Optional<User> findByEmail(String email);
	User findByIdIs(Long id);
	List<User> findAllByHalls(Hall hall);
	List<User> findByHallsNotContains(Hall hall);
	List<User> findByCreatedOrderIdIs(Long id);
	
}
