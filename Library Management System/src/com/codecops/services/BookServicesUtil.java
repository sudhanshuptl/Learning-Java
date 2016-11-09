package com.codecops.services;

import java.util.Collections;
import com.codecops.lms.*;
import java.util.Comparator;
import java.util.List;

public class BookServicesUtil implements 
        java.io.Serializable {

    /*
     * sort by rating.
     */
    public static void sortByRating(List<Books> booksList) {
        // Sorting books by rating
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

    /*
     * to sort book by author
     */

    public static void sortByAuthor(List<Books> booksList) {
        // Sorting books by Author
        Collections.sort(booksList, new Comparator<Books>() {
            public int compare(Books book1, Books book2) {
                return book1.getAuthor().compareToIgnoreCase(book2.getAuthor());
            }
        });
        displayBookList(booksList);
    }

    /*
     * to sort book by name
     */
    public static void sortByName(List<Books> booksList) {
        // Sorting books by book name
        Collections.sort(booksList, new Comparator<Books>() {
            public int compare(Books book1, Books book2) {
                return book1.getBookName().compareToIgnoreCase(
                        book2.getBookName());
            }
        });
        displayBookList(booksList);
    }

    /*
     * to sort book by ID
     */
    public static void sortByID(List<Books> booksList) {
        // Sorting books by book id
        Collections.sort(booksList, new Comparator<Books>() {
            public int compare(Books book1, Books book2) {
                return book2.getBookId() - book1.getBookId();
            }
        });
        displayBookList(booksList);
    }

    /*
     * to search book on the basis of various parameters
     */
    public static int searchByID(int id, List<Books> booksList) {
        // searching by book ID
        System.out.println("Searching for ID : " + id);
        System.out
                .println("                                  Book Details                                  \n");
        System.out
                .println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
        System.out
                .println("********************************************************************************");
        for (Books book : booksList) {
            if ((book.getBookId() == id) && book.isBookAvailability()) {
                System.out.println(book.getBookId() + "\t\t"
                        + book.getBookName() + "\t\t" + book.getAuthor()
                        + "\t\t" + book.getBookRating() + "\t\t"
                        + book.isBookAvailability());
                // System.out.println("BookName:" + book.getBookName() +
                // "Author:" + book.getAuthor() + "rating:"
                // + book.getBookRating() + "Availabel:" +
                // book.isBookAvailability());
                return id;
            } else if ((book.getBookId() == id) && (!book.isBookAvailability())) {
                System.out.println(book.getBookId() + "\t\t"
                        + book.getBookName() + "\t\t" + book.getAuthor()
                        + "\t\t" + book.getBookRating() + "\t\t"
                        + book.isBookAvailability());
                // System.out.println("BookName:" + book.getBookName() +
                // "Author:" + book.getAuthor() + "rating:"
                // + book.getBookRating() + "Availabel:" +
                // book.isBookAvailability());
                return 0;
            }
        }
        System.out.println("Book not availabel");
        return 0;
    }

    /*
     * to search a book by name
     */
    public static int searchByName(String name, List<Books> booksList) {
        // searching by book name
        int counter = 0;
        System.out.println("Searching for Book name" + name);
        System.out
                .println("                                  Book Details                                  \n");
        System.out
                .println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
        System.out
                .println("********************************************************************************");
        for (Books book : booksList) {
            if ((book.getBookName().contains(name) && book.isBookAvailability())) {
                System.out.println(book.getBookId() + "\t\t"
                        + book.getBookName() + "\t\t" + book.getAuthor()
                        + "\t\t" + book.getBookRating() + "\t\t"
                        + book.isBookAvailability());
                counter++;
                // return book.getBookId();
            } else if ((book.getBookName().contains(name) && (!book
                    .isBookAvailability()))) {
                System.out.println(book.getBookId() + "\t\t"
                        + book.getBookName() + "\t\t" + book.getAuthor()
                        + "\t\t" + book.getBookRating() + "\t\t"
                        + book.isBookAvailability());
                // return 0;
            }
        }
        if (counter == 0)
            System.out.println("Book not available");
        return counter;
    }

    /*
     * to search book by author
     */

    public static int searchByAuthor(String author, List<Books> booksList) {
        // searching by book Author
        int counter = 0;
        System.out.println("Searching for Book with Author:" + author);
        System.out
                .println("                                  Book Details                                  \n");
        System.out
                .println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
        System.out
                .println("********************************************************************************");
        for (Books book : booksList) {
            if ((book.getAuthor().equalsIgnoreCase(author) && book
                    .isBookAvailability())) {
                counter++;
                System.out.println(book.getBookId() + "\t\t"
                        + book.getBookName() + "\t\t" + book.getAuthor()
                        + "\t\t" + book.getBookRating() + "\t\t"
                        + book.isBookAvailability());
                // return book.getBookId();
            } else if ((book.getAuthor().equalsIgnoreCase(author) && (!book
                    .isBookAvailability()))) {
                System.out.println(book.getBookId() + "\t\t"
                        + book.getBookName() + "\t\t" + book.getAuthor()
                        + "\t\t" + book.getBookRating() + "\t\t"
                        + book.isBookAvailability());
                // return 0;
            }
        }
        if (counter == 0)
            System.out.println("Book not available");
        return counter;
    }

    /*
     * to search book by rating
     */
    public static int searchByRating(double rating, List<Books> booksList) {
        // searching by book rating
        int counter = 0;
        System.out.println("Searching for books with rating:" + rating);
        System.out
                .println("                                  Book Details                                  \n");
        System.out
                .println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
        System.out
                .println("********************************************************************************");
        for (Books book : booksList) {
            if ((Math.abs(book.getBookRating() - rating) < 0.000001)
                    && book.isBookAvailability()) {// (book.getBookRating() ==
                                                   // rating)
                System.out.println(book.getBookId() + "\t\t"
                        + book.getBookName() + "\t\t" + book.getAuthor()
                        + "\t\t" + book.getBookRating() + "\t\t"
                        + book.isBookAvailability());
                counter++;
                // return book.getBookId();
            } else if ((Math.abs(book.getBookRating() - rating) < 0.000001)
                    && (!book.isBookAvailability())) {
                System.out.println(book.getBookId() + "\t\t"
                        + book.getBookName() + "\t\t" + book.getAuthor()
                        + "\t\t" + book.getBookRating() + "\t\t"
                        + book.isBookAvailability());
                // return 0;
            }
        }
        if (counter == 0)
            System.out.println("Book not available");
        return counter;
    }

//    public int compare(Books o1, Books o2) {
//        // TODO Auto-generated method stub
//        return 0;
//    }

    /*
     * to display book list
     */
    public static void displayBookList(List<Books> booksList) {
        // Display all book detail
        System.out
                .println("                                  Book Details                                  \n");
        System.out
                .println("Book Id\t\tBook Name\tAuthor Name\tRatings\t\tAvailability");
        System.out
                .println("********************************************************************************");
        for (Books book : booksList) {
            System.out.println(book.getBookId() + "\t\t" + book.getBookName()
                    + "\t\t" + book.getAuthor() + "\t\t" + book.getBookRating()
                    + "\t\t" + book.isBookAvailability());
        }
    }

    /*
     * to issue a book
     */
    public void issueBook(int memberId, int bookId, Database database) {
        Members members = null;
        for (Members member : database.membersList) {
            if (memberId == member.getUserId()) {
                members = member;
                break;
            }
        }
        int flag = 0;
        if(members!=null){
        for (int index = 0; index < database.booksList.size(); index++) {
            if (database.booksList.get(index).getBookId() == bookId
                    && database.booksList.get(index).isBookAvailability() == true) {
                if (members.addIssuedBooks(bookId)) {
                    flag = 1;
                    database.booksList.get(index).setBookAvailability(false);
                    System.out.println("Isuue Completed !!");
                    break;
                } else {
                    flag = 2;
                }

            }
        }
        }
        else{
        	System.out.println("There is no memebr available with This ID");
        }

        if (flag == 0) {
            System.out.println("Book Not found or not available !!");
        }
        if (flag == 2) {
            System.out.println("exeeded your limits  !!");
        }
    }

    /*
     * to return a book
     */
    public void returnBooks(int memberId, int bookId, Database database) {
        Members members = null;
        for (Members member : database.membersList) {
            if (memberId == member.getUserId()) {
                members = member;
                break;
            }
        }
        int flag = 0;
        if(members !=null){
        if (members.removeIssuedBooks(bookId)) {
            flag = 1;
            for (int j_index = 0; j_index < database.booksList.size(); j_index++) {
                if (database.booksList.get(j_index).getBookId() == bookId) {
                    database.booksList.get(j_index).setBookAvailability(true);
                    break;
                }
            }
            System.out.println(" Return Completed,");
        }
        }
        else{
        	System.out.println("No member find with this Id");
        }
        if (flag == 0) {
            System.out.println("Not Found try again");
        }
    }
}