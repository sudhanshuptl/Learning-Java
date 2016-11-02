package com.codecops.myapp;

import com.codecops.myapp.service.*;

public class ATM {
	public static void main(String[] args){
		Account account1 = new Account();
		AccountService accountService=new AccountService();
		
		accountService.deposit(account1, 20000);
		
		
		
		/*
		account1.createAccount(1001, "Sudhanshu Patel",20000);
		Account account2=new Account();
		account2.createAccount(1001, "Shounak bahara h",30); //creating new account;
		
		
		account1.getAccountDetail();
		account2.getAccountDetail();
		
		double currentBlance = account1.getBalance();
		if (currentBlance>=10000){
			account1.withdrow(10000);
			System.out.println("Updated balance is := "+account1.getBalance());
			
		}
		else{
			System.out.println("Insufficient balance");
		}
		*/
	}

}
