package com.codecops.myapp.service;

import com.codecops.myapp.*;

public class AccountService { //service block
	

	public void createAccount(Account account,int id,String name,double bal){
		account.setAccountId(id);
		account.setAccountHName(name);
		account.setBalance(bal);
	}
	
	public void deposit(Account account,double amount){
		double currentBalance =account.getBalance();
		double updateBalance=currentBalance+amount;
		account.setBalance(updateBalance);
	}
	
	public void withdraw(Account account,double amount){
		double currentBalance=account.getBalance();
		if(currentBalance>amount){
			double updateBalance=currentBalance-amount;
			account.setBalance(updateBalance);
		}
		else{
			System.out.println("Insufficient Balance, Please check the amount");
		}
		
	}
	
	public void transferMoney(Account account1,Account account2,double amount){
		double currentBalance1=account1.getBalance();
		double currentBalance2=account2.getBalance();
		double updateBalance1;
		double updateBalance2;
	
		if(currentBalance1>amount){
			updateBalance1=currentBalance1-amount;
			updateBalance2=currentBalance2+amount;
			
			account1.setBalance(updateBalance1);
			account2.setBalance(updateBalance2);
		}
		else{
			System.out.println("Insufficient Balance, Please check the amount");
		}
	}
	
	public void printAccountInfo(Account acc){
		System.out.println("Account holder Name := "+acc.getAccountHName());
		System.out.println("Account ID := "+acc.getAccountId());
		System.out.println("Account Balance := "+acc.getBalance());
	}
	public void searchById(Account[] accArray,int id){
	
		for(int i=0;i<accArray.length;i++){
			if(accArray[i].getAccountId()==id){
				printAccountInfo(accArray[i]);break;
				
			}
			
		}
	}
	public void searchByName(Account[] accArray,String name){
	
		for(int i=0;i<accArray.length;i++){
			if(accArray[i].getAccountHName()==name){
				printAccountInfo(accArray[i]);
			    break;
			}
			
		}
		
	}
	
}
