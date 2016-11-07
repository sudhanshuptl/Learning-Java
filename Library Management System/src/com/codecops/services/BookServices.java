package com.codecops.services;

import java.util.List;
import java.util.Scanner;

import com.codecops.lms.Books;

public class BookServices {

	List<Books> booksList;

	public void setBooksList(List<Books> booksList) {
		this.booksList = booksList;
	}

	public void sortBooks(int n) {
		
//		System.out.println("Enter 1 for Sort by ID");
//		System.out.println("Enter 2 for Sort by Name");
//		System.out.println("Enter 3 for Sort by Author");
//		System.out.println("Enter 4 for Sort by Rating");
		switch (n) {
		case 1:
			BookServicesUtil.sortByID(this.booksList);
			break;
		case 2:
			BookServicesUtil.sortByName(this.booksList);
			break;
		case 3:
			BookServicesUtil.sortByAuthor(this.booksList);
			break;
		case 4:
			BookServicesUtil.sortByRating(this.booksList);
			break;
		default:
			System.out.println("Enter a valid choice");
		}
	}

	public void searchBooks() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for Search by ID");
		System.out.println("Enter 2 for Search by Name");
		System.out.println("Enter 3 for Search by Author");
		System.out.println("Enter 4 for Search by Rating");
		int n = Integer.parseInt(sc.next());
		switch (n) {
		case 1:
			System.out.println("Enter the Id to search");
			int id = sc.nextInt();
			BookServicesUtil.searchByID(id, this.booksList);
			break;
		case 2:
			System.out.println("Enter the Book Name to search");
			String name = sc.next();
			BookServicesUtil.searchByName(name, this.booksList);
			break;
		case 3:
			System.out.println("Enter the Author Name to search");
			String author = sc.next();
			BookServicesUtil.searchByAuthor(author, this.booksList);
			break;
		case 4:
			System.out.println("Enter the Rating to search");
			double rating = sc.nextDouble();
			BookServicesUtil.searchByRating(rating, this.booksList);
			break;
		default:
			System.out.println("Enter a valid choice");
		}
		sc.close();
	}
}