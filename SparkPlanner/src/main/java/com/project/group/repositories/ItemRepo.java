package com.project.group.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.group.models.Item;
import com.project.group.models.Order;
import com.project.group.models.User;


@Repository
public interface ItemRepo extends CrudRepository<Item, Long>{
	List<Item> findAll();
	Item findByIdIs(Long id);
	List<User> findAllByOrders(Order order);
	List<User> findByOrdersNotContains(Order order);
	List<User> findByHallIdIs(Long id);
}
