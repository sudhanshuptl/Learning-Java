package com.java.relations;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//Bidirectional
@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int passId;
	@OneToOne(cascade =CascadeType.ALL )
	private Person person;
	public int getPassId() {
		return passId;
	}
	public void setPassId(int passId) {
		this.passId = passId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
