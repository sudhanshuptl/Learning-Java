package com.codecops.services;

import java.util.Scanner;

import com.codecops.lms.Books;
import com.codecops.lms.Members;

public class AdminServices {
    /*
     * to add up new user to the database
     */

    public void addUser(Database database, String name, String passwd,long mobileNumber) {
        int id = database.getMemberId();
        id = id + 1;
        database.setMemberId(id);
        try {
            database.membersList.add(new Members(id, name, mobileNumber, passwd));
            System.out.println("User added successfully!!!");
        } catch (Exception e) {
            System.out.println("failure in adding user, try again with valid data");
            e.printStackTrace();
        }
    }

    /*
     * to display the user details.
     */

    public void displayUserDetails(Database database) {
        System.out
                .println("Id \tName \tMobile Number     Issued book 1     Issued Book 2  Issued Book 3 ");
        System.out
                .println("********************************************************************************");
        for (Members mem : database.membersList) {
            System.out.print(mem.getUserId() + "\t" + mem.getName() + "\t"
                    + mem.getMobileNumber());
            	System.out.println(mem.getIssuedBooks());
            	System.out.println();
        }
    }

    /*
     * to remove a user details.
     */
    public void removeUser(Database database, int userId) {
        for (int i = 0; i < database.membersList.size(); i++) {
            if (database.membersList.get(i).getUserId() == userId) {
                database.membersList.remove(database.membersList.get(i));
                System.out.println("User " + userId + " Removed Successfully");
            }
        }
    }

    /*
     * to update the name of the user.
     */
    public void updateUserDetails(Database database, String name, int userId) {
    	boolean flag=true;
        for (int i = 0; i < database.membersList.size(); i++) {
            if (database.membersList.get(i).getUserId() == userId) {
            	flag=false;
                database.membersList.get(i).setName(name);
                System.out.println("Name Updated Successfully");
            }
        }
        if(flag){
        	System.out.println("User not found, Please Eneter Valid userId");
        }
    }

    /*
     * to update the phone no of the user.
     */
    public void updateUserDetails(Database database, long mobileNumber,int userId) {
    	boolean flag=true;
        for (int i = 0; i < database.membersList.size(); i++) {
            if (database.membersList.get(i).getUserId() == userId) {
            	flag=false;
                database.membersList.get(i).setMobileNumber(mobileNumber);
                System.out.println("Phone Number Updated Successfully");
            }
        }
        if(flag){
        	System.out.println("User not found, Please Eneter Valid userId");
        }
    }

    /*
     * to update the password of the user.
     */
    public void updateUserDetails(Database database, int userId) {
        System.out.println("Enter new password : ");
        Scanner scanner = new Scanner(System.in);
        String adminUpdatePassword = scanner.next();
        boolean flag=true;
        for (int i = 0; i < database.membersList.size(); i++) {
            if (database.membersList.get(i).getUserId() == userId) {
            	flag=false;
                database.membersList.get(i).setPasswd(adminUpdatePassword);
                System.out.println("Password Changed Successfully");
            }
        }
        if(flag){
        	System.out.println("User not found, Please Eneter Valid userId");
        }
        scanner.close();
    }

    /*
     * to add up a new book in the database.
     */
    public void addBook(Database database, String bookName, String authorName,double rating) {
        int id = database.getBookId();
        id = id + 1;
        database.setBookId(id);
        try {
            database.booksList.add(new Books(id, bookName, authorName, true,
                    rating));
            System.out.println("Book added successfully!!!");
        } catch (Exception e) {
            System.out.println("There is an error in addtion!");
            e.printStackTrace();
        }
    }

    /*
     * to remove the book from the database
     */
    public void removeBook(Database database, int bookId) {
    	boolean flag=true;
        for (int i = 0; i < database.booksList.size(); i++) {
            if (database.booksList.get(i).getBookId() == bookId) {
            	flag=false;
                database.booksList.remove(database.booksList.get(i));
                System.out.println("Book Removed Successfully");
            }
        }
        if(flag){
        	System.out.println("Book not found, Please Eneter Valid bookId");
        }
    }

    /*
     * to display the book details
     */
    public void displayBookDetails(Database database) {
        System.out
                .println("                                  Book Details                                  \n");
        System.out
                .println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
        System.out
                .println("********************************************************************************");
        for (Books book : database.booksList) {
            System.out.println(book.getBookId() + "\t\t" + book.getBookName()
                    + "\t\t" + book.getAuthor() + "\t\t" + book.getBookRating()
                    + "\t\t" + book.isBookAvailability());
        }
    }

    /*
     * to display the book of the database.
     */
    public void updateBookDetails(Database database, int bookId) {
        for (int i = 0; i < database.booksList.size(); i++) {
            if (database.booksList.get(i).getBookId() == bookId) {
                boolean bookAvailability = database.booksList.get(i)
                        .isBookAvailability();
                database.booksList.get(i)
                        .setBookAvailability(!bookAvailability);
                System.out.println("Book Updated Successfully");
            }
        }
    }
}
