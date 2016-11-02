package com.virtusa.myapp;

public class Account {
		int accountId;
		String sccountName;
		double balance;
		
		public void deposite(double amount){
			balance +=amount;
		}
}
