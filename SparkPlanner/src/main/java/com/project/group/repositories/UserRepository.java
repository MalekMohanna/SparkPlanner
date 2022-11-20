package com.project.group.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.group.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    List<User> findAll();
	Optional<User> findByEmail(String email);
	User findByIdIs(Long id);
	List<User> findAllByHalls(Hall hall);
	List<User> findByHallsNotContains(Hall hall);
	List<User> findByCreatedOrderIdIs(Long id);

}