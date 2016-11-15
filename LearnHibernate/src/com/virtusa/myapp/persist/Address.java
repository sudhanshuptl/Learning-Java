package com.virtusa.myapp.persist;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Address implements Serializable {

	
		private String city;
		private int pincode;
		
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}

	

}
