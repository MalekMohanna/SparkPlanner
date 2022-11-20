package com.project.group.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="halls")
public class Hall {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Prise of Invittes")
    private Double price;
	
	@NotEmpty(message="Hall name is required!")
    @Size(min=3, max=30, message="Hall name must be between 3 and 30 characters")
    private String name;
	
	@NotEmpty(message="Location name is required!")
    @Size(min=3, max=30, message="Location name must be between 3 and 30 characters")
    private String location;
	
	@NotEmpty(message="Area is required!")
    private Integer area;
	
	@NotEmpty(message="Number of Visitors is required!")
    private Integer num_of_visitors;
	
	
    @OneToMany(mappedBy="hall", fetch = FetchType.LAZY)
    private List<Item> items;
    
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_has_hall",
               joinColumns = @JoinColumn(name = "hall_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
	
    
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Hall() {
		
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getNum_of_visitors() {
		return num_of_visitors;
	}
	public void setNum_of_visitors(Integer num_of_visitors) {
		this.num_of_visitors = num_of_visitors;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
	protected void onCreated() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
    }
}
