package com.codecops.lms;

public class Books {
	private int bookId;
	private String bookName;
	private String author;
	private boolean bookAvailability;
	private double bookRating;
	

	public Books(int bId, String bName, String aName, boolean bAvail,double rating) {
		this.bookId = bId;
		this.bookName = bName;
		this.author = aName;
		this.bookAvailability = bAvail;
		this.bookRating = rating;
		

	}

	public void setBookAvailability(boolean bookAvailability) {
		this.bookAvailability = bookAvailability;
	}

	public String getAuthor() {
		return author;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public boolean isBookAvailability() {
		return bookAvailability;
	}

	public double getBookRating() {
		return bookRating;
	}
}
