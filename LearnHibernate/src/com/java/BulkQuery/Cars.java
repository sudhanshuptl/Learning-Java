package com.java.BulkQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name="basic",query="select car from Cars car")
public class Cars {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int carId;
	private String carName;
//	public Cars(String name){
//		this.carName=name;
//	}
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	
}
