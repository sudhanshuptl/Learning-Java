package com.codecops.services;

import java.util.Scanner;

import com.codecops.lms.Books;
import com.codecops.lms.Members;

public class AdminServices {

	public void addUser(Database database, String name, String passwd, long mobileNumber) {

		int id = ++database.memberId;
		try {
			database.membersList.add(new Members(id, name, mobileNumber, passwd));
			System.out.println("User added successfully!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayUserDetails(Database database) {
		System.out.println("Id \tName \tMobile Number     Issued book 1     Issued Book 2  Issued Book 3 ");
		System.out.println("********************************************************************************");
		for (Members mem : database.membersList) {
			System.out.println(mem.getUserId() + "\t" + mem.getName() + "\t" + mem.getMobileNumber() + "\t\t" + mem.getIssuedBooks()[0] + "\t\t" + mem.getIssuedBooks()[1] + "\t\t" + mem.getIssuedBooks()[2]);
		}
	}

	public void removeUser(Database database, int userId) {
		for (int i = 0; i < database.membersList.size(); i++) {
			if (database.membersList.get(i).getUserId() == userId){
				database.membersList.remove(database.membersList.get(i));
				System.out.println("User " + userId + " Removed Successfully");
			}
		}
	}

	public void updateUserDetails(Database database, String name, int userId) {
		for (int i = 0; i < database.membersList.size(); i++) {
			if (database.membersList.get(i).getUserId() == userId){
				database.membersList.get(i).setName(name);
				System.out.println("Name Updated Successfully");
			}
		}
	}

	public void updateUserDetails(Database database, long mobileNumber, int userId) {
		for (int i = 0; i < database.membersList.size(); i++) {
			if (database.membersList.get(i).getUserId() == userId){
				database.membersList.get(i).setMobileNumber(mobileNumber);
				System.out.println("Phone Number Updated Successfully");
			}
		}
	}

	public void updateUserDetails(Database database, int userId) {
		System.out.println("Enter new password : ");
		Scanner scanner = new Scanner(System.in);
		String adminUpdatePassword = scanner.next();
		for (int i = 0; i < database.membersList.size(); i++) {
			if (database.membersList.get(i).getUserId() == userId){
				database.membersList.get(i).setPasswd(adminUpdatePassword);
				System.out.println("Password Changed Successfully");
			}
		}
	}

	public void addBook(Database database, String bookName, String authorName, double rating) {

		int id = ++database.bookId;
		try {
			database.booksList.add(new Books(id, bookName, authorName, true, rating));
			System.out.println("Book added successfully!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeBook(Database database, int bookId) {
		for (int i = 0; i < database.booksList.size(); i++) {
			if (database.booksList.get(i).getBookId() == bookId){
				database.booksList.remove(database.booksList.get(i));
				System.out.println("Book Removed Successfully");
			}
		}
	}

	public void displayBookDetails(Database database) {
		System.out.println("                                  Book Details                                  \n");
		System.out.println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
		System.out.println("********************************************************************************");
		for (Books book : database.booksList) {
			System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
					+ book.getBookRating() + "\t\t" + book.isBookAvailability());
		}
	}

	public void updateBookDetails(Database database, int bookId) {
		for (int i = 0; i < database.booksList.size(); i++) {
			if (database.booksList.get(i).getBookId() == bookId){
				boolean bookAvailability = database.booksList.get(i).isBookAvailability();
				database.booksList.get(i).setBookAvailability(!bookAvailability);
				System.out.println("Book Updated Successfully");
			}
		}
	}
}
