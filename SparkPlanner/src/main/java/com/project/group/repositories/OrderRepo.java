package com.project.group.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.group.models.Item;
import com.project.group.models.Order;
import com.project.group.models.User;


@Repository
public interface OrderRepo extends CrudRepository<Order, Long>{
	List<Order> findAll();
	
	 Order findByIdIs(Long id);
	List<Order> findAllByItems(Item item);
	List<Order> findByItemsNotContains(Item item);
	List<Order> findByUserIdIs(Long id);
	
}
