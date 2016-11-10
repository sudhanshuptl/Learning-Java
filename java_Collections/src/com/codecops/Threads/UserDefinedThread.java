package com.codecops.Threads;

import java.lang.Thread;
public class UserDefinedThread extends Thread{
	
	// The code which you want to run separately  from main musk kept here
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("print i ="+i);
		}
	}

	public static void main(String[] args){
		UserDefinedThread udf = new UserDefinedThread(); //create thread object
		udf.start(); //Make it thread of execution means create new thread and run
		
//		UserDefinedThread udf1 = new UserDefinedThread(); //create thread object
//		udf1.start(); //Make it thread of execution means create new thread and run
//		
		
		System.out.println("i am in main");
	}
}
