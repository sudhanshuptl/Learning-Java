package com.codecops.myapp;

import com.codecops.myapp.service.*;

public class ATM {
	public static void main(String[] args){
		//Account account1 = new Account();
		//Account account1 = new Account(1001,"Sudhanshu Patel",1000000);
		AccountService accountService=new AccountService();
		//accountService.deposit(account1, 20000);
		
		Account[] accountDatabase= new Account[5];
		
		accountDatabase[0]=new Account(1001,"Sudhanshu Patel",1000000);
		accountDatabase[1]=new Account(1002,"Shounak bahara",10000);
		accountDatabase[2]=new Account(1005,"Chandan meher",20000);
		accountDatabase[3]=new Account(1010,"Sajan",30000);
		accountDatabase[4]=new Account(1008,"Aditya",100);
		
		//accountService.searchById(accountDatabase,1008);
		accountService.searchByName(accountDatabase, "Sajan");
		
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
