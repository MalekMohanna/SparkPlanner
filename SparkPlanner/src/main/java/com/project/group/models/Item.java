package com.project.group.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="items")
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Prise of Invittes")
    private Double price;
	
	@NotEmpty(message="Name is required!")
    @Size(min=8, max=40, message="Name must be between 8 and 40 characters")
    private String name;
	
	@NotEmpty(message="Type is required!")
    @Size(min=8, max=40, message="Type must be between 8 and 40 characters")
    private String type;
	
	@NotEmpty(message="Quantity of Invittes")
    private Integer quantity;
	public Item() {}
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "items_has_order", 
        joinColumns = @JoinColumn(name = "item_id"), 
        inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hall_id")
    private Hall hall;
    
 
	public Hall getHall() {
		return hall;
	}


	public void setHall(Hall hall) {
		this.hall = hall;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
