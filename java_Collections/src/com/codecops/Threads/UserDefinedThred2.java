package com.codecops.Threads;


// This advantage over the fist method becouse it can extend ssome other class
public class UserDefinedThred2  implements Runnable{
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("print i = "+i);
		}
	}

public static void main(String[] args) {
	UserDefinedThred2 udt =new UserDefinedThred2();
	Thread t1 = new Thread(udt);
	t1.start();
	
	System.out.println("i am in main");
	}

}
