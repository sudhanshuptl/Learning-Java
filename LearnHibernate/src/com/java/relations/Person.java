package com.java.relations;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String name;
	@OneToOne(cascade =CascadeType.ALL )
	private Passport pass;
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
	public Passport getPass() {
		return pass;
	}
	public void setPass(Passport pass) {
		this.pass = pass;
	}
	
}
