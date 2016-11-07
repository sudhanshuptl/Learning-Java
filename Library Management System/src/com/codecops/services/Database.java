package com.codecops.services;

import java.util.ArrayList;
import java.util.List;

import com.codecops.lms.Books;
import com.codecops.lms.Members;

public class Database {

	public List<Members> membersList = new ArrayList<Members>();
	public List<Books> booksList = new ArrayList<Books>();
	public List<Transaction> transactionRecord= new ArrayList<Transaction>();
	
	public static int memberId = 105; 
	public static int bookId = 103;
	public  int transactionId=1001;


	public Database() {
		// TODO Auto-generated constructor stub
		booksList.add(new Books(101, "book1", "aut", true, 4.5));
		booksList.add(new Books(102, "book2", "aut", true, 3.5));
		booksList.add(new Books(103, "book3", "aut", true, 4));

		membersList.add(new Members(101, "Jack", 3333333333l, "abcd"));
		membersList.add(new Members(102, "John", 1111111111l, "abcd"));
		membersList.add(new Members(103, "Jil", 4545454544l, "abcd"));
		membersList.add(new Members(104, "Eddi", 7878787875l, "abcd"));
		membersList.add(new Members(105, "Gorge", 7878789995l, "abcd"));

	}
}