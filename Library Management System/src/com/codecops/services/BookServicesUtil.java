package com.codecops.services;

import java.util.Date;
import java.util.Collections;
import com.codecops.lms.*;
import java.util.Comparator;
import java.util.List;

public class BookServicesUtil implements Comparator<Books> {

	public static void sortByRating(List<Books> booksList) {
		// TODO Auto-generated method stub
		Collections.sort(booksList, new Comparator<Books>() {
			public int compare(Books book1, Books book2) {
				if (book1.getBookRating() < book2.getBookRating())
					return -1;
				else if (book1.getBookRating() > book2.getBookRating())
					return 1;
				else
					return 0;

			}
		});
		displayBookList(booksList);
	}

	public static void sortByAuthor(List<Books> booksList) {
		// TODO Auto-generated method stub
		Collections.sort(booksList, new Comparator<Books>() {
			public int compare(Books book1, Books book2) {
				return book1.getAuthor().compareToIgnoreCase(book2.getAuthor());
			}
		});
		displayBookList(booksList);
	}

	public static void sortByName(List<Books> booksList) {
		// TODO Auto-generated method stub
		Collections.sort(booksList, new Comparator<Books>() {
			public int compare(Books book1, Books book2) {
				return book1.getBookName().compareToIgnoreCase(book2.getBookName());
			}
		});
		displayBookList(booksList);
	}

	public static void sortByID(List<Books> booksList) {
		// TODO Auto-generated method stub
		Collections.sort(booksList, new Comparator<Books>() {
			public int compare(Books book1, Books book2) {
				return book2.getBookId() - book1.getBookId();
			}
		});
		displayBookList(booksList);
	}

	public static int searchByID(int id, List<Books> booksList) {
		// TODO Auto-generated method stub
		System.out.println("Searching for ID : " + id);
		System.out.println("                                  Book Details                                  \n");
		System.out.println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
		System.out.println("********************************************************************************");
		for (Books book : booksList) {
			if ((book.getBookId() == id) && book.isBookAvailability()) {
				System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
						+ book.getBookRating() + "\t\t" + book.isBookAvailability());
				//System.out.println("BookName:" + book.getBookName() + "Author:" + book.getAuthor() + "rating:"
				//		+ book.getBookRating() + "Availabel:" + book.isBookAvailability());
				return id;
			} else if ((book.getBookId() == id) && (!book.isBookAvailability())) {
				System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
						+ book.getBookRating() + "\t\t" + book.isBookAvailability());
				//System.out.println("BookName:" + book.getBookName() + "Author:" + book.getAuthor() + "rating:"
				//		+ book.getBookRating() + "Availabel:" + book.isBookAvailability());
				return 0;
			}
		}
		System.out.println("Book not availabel");
		return 0;
	}

	public static int searchByName(String name, List<Books> booksList) {
		// TODO Auto-generated method stub
		int counter = 0;
		System.out.println("Searching for Book name" + name);
		System.out.println("                                  Book Details                                  \n");
		System.out.println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
		System.out.println("********************************************************************************");
		for (Books book : booksList) {
			if ((book.getBookName().contains(name) && book.isBookAvailability())) {
				System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
						+ book.getBookRating() + "\t\t" + book.isBookAvailability());
				counter++;
				//return book.getBookId();
			} else if ((book.getBookName().contains(name) && (!book.isBookAvailability()))) {
				System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
						+ book.getBookRating() + "\t\t" + book.isBookAvailability());
				//return 0;
			}
		}
		if(counter == 0)
			System.out.println("Book not available");
		return counter;
	}

	public static int searchByAuthor(String author, List<Books> booksList) {
		// TODO Auto-generated method stub
		int counter=0;
		System.out.println("Searching for Book with Author:" + author);
		System.out.println("                                  Book Details                                  \n");
		System.out.println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
		System.out.println("********************************************************************************");
		for (Books book : booksList) {
			if ((book.getAuthor().equalsIgnoreCase(author) && book.isBookAvailability())) {
				counter++;
				System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
						+ book.getBookRating() + "\t\t" + book.isBookAvailability());
				//return book.getBookId();
			} else if ((book.getAuthor().equalsIgnoreCase(author) && (!book.isBookAvailability()))) {
				System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
						+ book.getBookRating() + "\t\t" + book.isBookAvailability());
				//return 0;
			}
		}
		if(counter == 0)
			System.out.println("Book not available");
		return counter;
	}

	public static int searchByRating(double rating, List<Books> booksList) {
		// TODO Auto-generated method stub
		int counter = 0;
		System.out.println("Searching for books with rating:" + rating);
		System.out.println("                                  Book Details                                  \n");
		System.out.println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
		System.out.println("********************************************************************************");
		for (Books book : booksList) {
			if ((book.getBookRating() == rating) && book.isBookAvailability()) {
				System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
						+ book.getBookRating() + "\t\t" + book.isBookAvailability());
				counter++;
				//return book.getBookId();
			} else if ((book.getBookRating() == rating) && (!book.isBookAvailability())) {
				System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
						+ book.getBookRating() + "\t\t" + book.isBookAvailability());
				//return 0;
			}
		}
		if(counter == 0)
			System.out.println("Book not available");
		return counter;
	}

	public int compare(Books o1, Books o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void displayBookList(List<Books> booksList) {
		System.out.println("                                  Book Details                                  \n");
		System.out.println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
		System.out.println("********************************************************************************");
		for (Books book : booksList) {
			System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t"
					+ book.getBookRating() + "\t\t" + book.isBookAvailability());
		}
	}

	/*****************************************************************/
	public void issueBook(int memberId, int bookId, Database database) {
		Members members = null;
		for (Members member : database.membersList) {
			if (memberId == member.getUserId()) {
				members = member;
				break;
			}
		}
		int flag = 0;
		for (int index = 0; index < database.booksList.size(); index++) {
			if (database.booksList.get(index).getBookId() == bookId
					&& database.booksList.get(index).isBookAvailability() == true) {
				int[] issuedBooks = members.getIssuedBooks();
				for (int jindex = 0; jindex < issuedBooks.length; jindex++) {
					if (issuedBooks[jindex] == 0) {
						flag = 1;
						issuedBooks[jindex] = bookId;
						members.setIssuedBooks(issuedBooks);
						database.booksList.get(index).setBookAvailability(false);
						Transaction transaction = new Transaction(database.transactionId, members.getUserId(), bookId,
								new Date());
						database.transactionId++;
						database.transactionRecord.add(transaction);
						System.out.println("Isuue Completed !!");
						break;
					}

				}

			}
		}
		if (flag == 0) {
			System.out.println("Book Not found or not available or exeeded your limits !!");
		}
	}

	public void returnBooks(int memberId, int bookId, Database database) {
		Members members = null;
		for (Members member : database.membersList) {
			if (memberId == member.getUserId()) {
				members = member;
				break;
			}
		}
		int flag = 0;
		int[] issuedBooks = members.getIssuedBooks();
		for (int index = 0; index < issuedBooks.length; index++) {
			if (bookId == issuedBooks[index]) {
				issuedBooks[index] = 0;
				flag = 1;
				members.setIssuedBooks(issuedBooks);
				for (int j_index = 0; j_index < database.booksList.size(); j_index++) {
					if (database.booksList.get(j_index).getBookId() == bookId) {
						database.booksList.get(j_index).setBookAvailability(true);
						break;
					}
				}
				Transaction transaction = new Transaction(database.transactionId, members.getUserId(), bookId,
						new Date());
				database.transactionRecord.add(transaction);
				System.out.println(" Return Completed,");
				break;
			}
		}
		if (flag == 0) {
			System.out.println("Not Found try again");
		}
	}
}