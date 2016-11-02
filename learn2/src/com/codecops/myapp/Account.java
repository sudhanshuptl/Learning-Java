package com.codecops.myapp;

public class Account {
	private int accountId;
	private String accountHName;
	private double balance;
	
	public void createAccount(int id,String name,double bal){
		accountId=id;
		accountHName=name;
		balance=bal;
	}
	public void deposite(double amount){
		balance +=amount;
	}
	public void withdrow(double amount){
		balance-=amount;
	}
	public void getAccountDetail(){
		System.out.println("Account holder Name := "+accountHName);
		System.out.println("Account Balance := "+balance);
	}
	public double getBalance(){ //if only want balance information
		return balance;
	}
	public String getAccountHName() {
		return accountHName;
	}
	public void setAccountHName(String accountHName) {
		this.accountHName = accountHName;
		
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
