package com.codecops.services;
import java.util.Date;
public class Transaction {
	
	private int transactionId;
	private int memberId;
	private int bookId;
	private Date date;
	
	public Transaction(int transactionId,int memberId,int bookId,Date date){
		this.memberId=memberId;
		this.bookId=bookId;
		this.date=date;
		this.transactionId=transactionId;
		
	}

	public int getTransactionId() {
		return transactionId;
	}

	public int getMemberId() {
		return memberId;
	}

	public int getBookId() {
		return bookId;
	}

	public Date getDate() {
		return date;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
