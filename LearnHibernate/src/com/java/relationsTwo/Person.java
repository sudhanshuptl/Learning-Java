package com.java.relationsTwo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
public class Person implements Serializable {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Cars> cars;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Cars> getCars() {
		return cars;
	}
	public void setCars(List<Cars> cars) {
		this.cars = cars;
	}


	
}
