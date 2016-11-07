package com.codecops.lms;

import java.util.Scanner;
import com.codecops.services.Database;
import com.codecops.services.AdminServices;
import com.codecops.services.BookServicesUtil;

public class LMSmain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Admin admin = new Admin(999, "Admin", 999999999, "admin");
		Database database = new Database();
		AdminServices adminServices = new AdminServices();
		BookServicesUtil bookServicesUtil = new BookServicesUtil();
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		char charToQuit = 'n';
		char charToQuitChooseUser = 'n';
		char charToQuitChooseMember = 'n';
		char charToQuitIssueBook = 'n';
		int adminSession = 0;
		int memberSession = 0;
		int memberID = 0;
		String memberPassword;
		int chooseUser;
		int adminOptions;
		int memberOptions;
		int searchBookOptions;
		int adminUpdate;
		int adminId = 999;
		String adminPassword;
		int loginCheck = 0;
		Scanner scanner = new Scanner(System.in);
		String LMS = "Welcome to Library Management System[LMS]";
		System.out.print("\n\n\n\n\t\t\t");
		for(int index = 0;index<LMS.length();index++)
		{
			System.out.print(LMS.charAt(index));
			Thread.sleep(100);
		}
		System.out.print("\n\n\n\n");
		System.out.println();
		//System.out.println("\n\n\n\n\t\t\tWelcome to Library Management System[LMS]\n\n\n\n");
		for (int i = 5; i >= 0; i--) {
			System.out.print(i+"\t");
			Thread.sleep(1000);
		}
		System.out.print("\n\n\n\n");

		do {
//			System.out.println("\n\n\n\n\t\t\tWelcome to Library Management System[LMS]\n\n\n\n");
//			for (int i = 5; i >= 0; i--) {
//				System.out.print("\t" + i);
//				// Thread.sleep(1000);
//			}
			System.out.println();
			System.out.print("Login as : \n\t\t1.Admin\n\t\t2.Member\n\t\t3.Quit\n\nEnter Choice:");
			chooseUser = scanner.nextInt();
			switch (chooseUser) {
			case 1:
				do {
					if (adminSession == 0) {
						do {
							System.out.print("\t\tUser ID : ");
							adminId = scanner.nextInt();
							System.out.print("\t\tPassword : ");
							adminPassword = scanner.next();
							if (admin.checkLogin(adminId, adminPassword)) {
								loginCheck = 1;
								adminSession = 1;
							} else {
								System.out.println("\nInvalid ID or Password!!!\nPlease try again\n");
								loginCheck = 0;
							}
						} while (loginCheck == 0);
					}
					System.out
							.print("\n\nLMS>ADMIN>\n\nADMIN Page : \n\t\t1.Add User\n\t\t2.Update User Details\n\t\t3.Remove User\n\t\t4.Display User Details"
									+ "\n\t\t5.Add Book\n\t\t6.Update Book Details\n\t\t7.Delete Book\n\t\t8.Display Book Details\n\t\t9.Logout\n\t\t10.Quit\n\nEnter Choice:");
					adminOptions = scanner.nextInt();
					switch (adminOptions) {
					case 1:
						System.out.print("Enter Name : ");
						String userName = scanner.next();
						System.out.print("Enter Password : ");
						String userpassword = scanner.next();
						System.out.print("Enter Mobile Number : ");
						long userMobNo = scanner.nextLong();
						adminServices.addUser(database, userName, userpassword, userMobNo);
						break;
					case 2:
						System.out.print("Enter ID of user : ");
						int userId = scanner.nextInt();
						System.out.print(
								"Update : \n\t\t1.Name\n\t\t2.Password\n\t\t3.Phone Number\n\t\t4.Go Back\n\t\t5.Logout\n\t\t6.Quit\n\nEnter Choice:");
						adminUpdate = scanner.nextInt();
						switch (adminUpdate) {
						case 1:
							System.out.print("Enter Name : ");
							String adminUpdateName = scanner.next();
							adminServices.updateUserDetails(database, adminUpdateName, userId);
							break;
						case 2:
							adminServices.updateUserDetails(database, userId);
							break;
						case 3:
							System.out.print("Enter Phone Number : ");
							long adminUpdateMobileNumber = scanner.nextLong();
							adminServices.updateUserDetails(database, adminUpdateMobileNumber, userId);
							break;
						case 4:
							charToQuitChooseUser = 'n';
							charToQuit = 'n';
							adminSession = 1;
							break;
						case 5:
							charToQuitChooseUser = 'y';
							charToQuit = 'n';
							adminSession = 0;
							break;
						case 6:
							charToQuitChooseUser = 'y';
							charToQuit = 'y';
							break;
						default:
							break;
						}
						break;
					case 3:
						System.out.print("Enter ID of user : ");
						userId = scanner.nextInt();
						adminServices.removeUser(database, userId);
						adminServices.displayUserDetails(database);
						break;
					case 4:
						adminServices.displayUserDetails(database);
						break;
					case 5:
						System.out.print("Enter book name : ");
						String bookName = scanner.next();
						System.out.print("Enter author name : ");
						String authorName = scanner.next();
						System.out.print("Enter book rating : ");
						double rating = scanner.nextDouble();
						adminServices.addBook(database, bookName, authorName, rating);
						break;
					case 6:
						System.out.print("Enter book ID : ");
						int bookId = scanner.nextInt();
						adminServices.updateBookDetails(database, bookId);
						break;
					case 7:
						System.out.print("Enter book ID : ");
						bookId = scanner.nextInt();
						adminServices.removeBook(database, bookId);
						break;
					case 8:
						adminServices.displayBookDetails(database);
						break;
					case 9:
						charToQuitChooseUser = 'y';
						charToQuit = 'n';
						adminSession = 0;
						break;
					case 10:
						charToQuitChooseUser = 'y';
						charToQuit = 'y';
						break;
					default:
						System.out.println("Invalid Choice!!! Please try again.");
						charToQuitChooseUser = 'n';
						break;
					}
				} while (charToQuitChooseUser == 'n');
				break;
			case 2:
				do {
					if (memberSession == 0) {
						do {
							System.out.print("\t\tUser ID : ");
							memberID = scanner.nextInt();
							System.out.print("\t\tPassword : ");
							memberPassword = scanner.next();
							if (Members.loginCheck(database,memberID, memberPassword)) {
								loginCheck = 1;
								memberSession = 1;
							} else {
								System.out.println("\nInvalid ID or Password!!!\nPlease try again\n");
								loginCheck = 0;
							}
						} while (loginCheck == 0);
					}
					System.out.print(
							"\n\nLMS>MEMBER>\n\nMEMBER : \n\t\t1.Issue book\n\t\t2.Return Book\n\t\t3.Search Books\n\t\t4.Logout\n\t\t5.Quit\n\nEnter Choice:");
					memberOptions = scanner.nextInt();
					switch (memberOptions) {
					case 1:
						do {
							System.out
									.print("\n\nLMS>MEMBER>ISSUE_BOOK>\n\nISSUE BOOK : \n\t\t1.Sort by ID\n\t\t2.Sort by Name\n\t\t3.Sort by Author\n\t\t4.Sort by Rating"
											+ "\n\t\t5.Search by ID\n\t\t6.Search by Name\n\t\t7.Search by Author\n\t\t8.Search by Rating\n\t\t9.Go Back\n\t\t10.Logout"
											+ "\n\t\t11.Quit\n\nEnter Choice:");
							searchBookOptions = scanner.nextInt();
							switch (searchBookOptions) {
							case 1:
								BookServicesUtil.sortByID(database.booksList);
								System.out.print("Enter Book ID : ");
								int bookId = scanner.nextInt();
								bookServicesUtil.issueBook(memberID, bookId, database);
								break;
							case 2:
								BookServicesUtil.sortByName(database.booksList);
								System.out.print("Enter Book ID : ");
								bookId = scanner.nextInt();
								bookServicesUtil.issueBook(memberID, bookId, database);
								break;
							case 3:
								BookServicesUtil.sortByAuthor(database.booksList);
								System.out.print("Enter Book ID : ");
								bookId = scanner.nextInt();
								bookServicesUtil.issueBook(memberID, bookId, database);
								break;
							case 4:
								BookServicesUtil.sortByRating(database.booksList);
								System.out.print("Enter Book ID : ");
								bookId = scanner.nextInt();
								bookServicesUtil.issueBook(memberID, bookId, database);
								break;
							case 5:
								System.out.print("Enter ID : ");
								int bookID = scanner.nextInt();
								bookID = BookServicesUtil.searchByID(bookID, database.booksList);
								if (bookID != 0)
									bookServicesUtil.issueBook(memberID, bookID, database);
								else
									System.out.println("Book cannot be issue.");
								break;
							case 6:
								System.out.print("Enter Name : ");
								String bookName = scanner.next();
								bookID = BookServicesUtil.searchByName(bookName, database.booksList);
								if (bookID != 0) {
									System.out.print("Enter ID : ");
									bookID = scanner.nextInt();
									bookServicesUtil.issueBook(memberID, bookID, database);
								} else
									System.out.println("Book cannot be issue.");
								break;
							case 7:
								System.out.print("Enter Author : ");
								String bookAuthorName = scanner.next();
								bookID = BookServicesUtil.searchByAuthor(bookAuthorName, database.booksList);
								if (bookID != 0) {
									System.out.print("Enter ID : ");
									bookID = scanner.nextInt();
									bookServicesUtil.issueBook(memberID, bookID, database);
								} else
									System.out.println("Book cannot be issue.");
								break;
							case 8:
								System.out.print("Enter Rating : ");
								double bookRating = scanner.nextDouble();
								bookID = BookServicesUtil.searchByRating(bookRating, database.booksList);
								if (bookID != 0) {
									System.out.print("Enter ID : ");
									bookID = scanner.nextInt();
									bookServicesUtil.issueBook(memberID, bookID, database);
								} else
									System.out.println("Book cannot be issue.");
								break;
							case 9:
								charToQuitIssueBook = 'y';
								charToQuit = 'n';
								break;
							case 10:
								charToQuitIssueBook = 'y';
								charToQuitChooseMember = 'y';
								charToQuit = 'n';
								memberSession = 0;
								break;
							case 11:
								charToQuitChooseMember = 'y';
								charToQuitIssueBook = 'y';
								charToQuit = 'y';
								break;
							default:
								System.out.println("Invalid Choice!!! Please try again.");
								charToQuitChooseUser = 'n';
								break;
							}

						} while (charToQuitIssueBook == 'n');
						break;
					case 2:
						System.out.print("Enter Book ID : ");
						int bookId = scanner.nextInt();
						bookServicesUtil.returnBooks(memberID, bookId, database);
						charToQuitIssueBook = 'n';
						charToQuitChooseMember = 'n';
						break;
					case 3:
						do {
							System.out.print(
									"\n\nLMS>MEMBER>ISSUE_BOOK>SEARCH_BOOK>\n\nSEARCH BOOK : \n\t\t1.Search by ID\n\t\t2.Search by Name\n\t\t3.Search by Author\n\t\t4.Search by Rating\n\t\t5.Go Back\n\t\t6.Quit\n\nEnter Choice:");
							searchBookOptions = scanner.nextInt();
							switch (searchBookOptions) {
							case 1:
								System.out.print("Enter ID : ");
								int bookID = scanner.nextInt();
								bookID = BookServicesUtil.searchByID(bookID, database.booksList);
								// if(bookID !=0){
								// System.out.println("Do you want to issue book
								// [y/n] : ");
								// char ch = scanner.next().charAt(0);
								// if(ch == 'y')
								// bookServicesUtil.issueBook(101, bookID,
								// database);
								// }
								// else
								// System.out.println("Book cannot be issue.");
								break;
							case 2:
								System.out.print("Enter Name : ");
								String bookName = scanner.next();
								bookID = BookServicesUtil.searchByName(bookName, database.booksList);
								// if(bookID !=0){
								// System.out.print("Enter ID : ");
								// bookID = scanner.nextInt();
								// bookServicesUtil.issueBook(101, bookID,
								// database);
								// }
								// else
								// System.out.println("Book cannot be issue.");
								break;
							case 3:
								System.out.print("Enter Author : ");
								String bookAuthorName = scanner.next();
								bookID = BookServicesUtil.searchByAuthor(bookAuthorName, database.booksList);
								// if(bookID !=0){
								// System.out.print("Enter ID : ");
								// bookID = scanner.nextInt();
								// bookServicesUtil.issueBook(101, bookID,
								// database);
								// }
								// else
								// System.out.println("Book cannot be issue.");
								break;
							case 4:
								System.out.print("Enter Rating : ");
								double bookRating = scanner.nextDouble();
								bookID = BookServicesUtil.searchByRating(bookRating, database.booksList);
								// if(bookID !=0){
								// System.out.print("Enter ID : ");
								// bookID = scanner.nextInt();
								// bookServicesUtil.issueBook(101, bookID,
								// database);
								// }
								// else
								// System.out.println("Book cannot be issue.");
								break;
							case 5:
								charToQuitIssueBook = 'y';
								charToQuit = 'n';
								break;
							case 6:
								charToQuitChooseMember = 'y';
								charToQuitIssueBook = 'y';
								charToQuit = 'y';
								break;
							default:
								System.out.println("Invalid Choice!!! Please try again.");
								charToQuitChooseUser = 'n';
								break;
							}

						} while (charToQuitIssueBook == 'n');

						break;
					case 4:
						charToQuitChooseMember = 'y';
						charToQuit = 'n';
						memberSession = 0;
						break;
					case 5:
						charToQuitChooseMember = 'y';
						charToQuit = 'y';
						break;
					default:
						System.out.println("Invalid Choice!!! Please try again.");
						charToQuitChooseMember = 'n';
						break;
					}
				} while (charToQuitChooseMember == 'n');
				break;
			case 3:
				System.out.println("Thanks Visit Again");
				charToQuit = 'y';
				break;
			default:
				System.out.println("Invalid Choice!!! Please try again.");
				charToQuit = 'n';
				break;
			}
		} while (charToQuit == 'n');
	}

}
