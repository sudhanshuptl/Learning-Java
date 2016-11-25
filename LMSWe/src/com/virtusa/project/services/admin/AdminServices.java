package com.virtusa.project.services.admin;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.project.ServiceMain;
import com.virtusa.project.books.Book;
import com.virtusa.project.services.database.DatabaseServices;
import com.virtusa.project.users.Member;

public class AdminServices {

	
	
	public void addUser(String userName,String password,String userPhoneNumber) {
		
		//ServiceMain serviceMain = new ServiceMain();
		Member member = new Member();
		//member.setId(serviceMain.intEntry("Id"));
		member.setUserName(userName);
		member.setUserPassword(password);
		member.setPhoneNumber(Long.parseLong(userPhoneNumber));

		Configuration cfg = DatabaseServices.config();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.save(member);
		transaction.commit();
		
		DatabaseServices databaseServices = new DatabaseServices();
		if(databaseServices.validateMemberId(member.getId())){
			ServiceMain.printAcknowledgeMessage("\nUser "+member.getUserName()+" added successfully\n");			
		}else{
			ServiceMain.printAcknowledgeMessage("\nSomething went wrong\n");
		}
		session.close();
		sessionFactory.close();

	}
	@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
	public String displayUserDetails() {
		String rowdata="";
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Member.class);
		List<Member> member = criteria.list();
//		Iterator it = member.iterator();
//		while (it.hasNext()) {
//			
//			System.out.println(it.next());
//		}
	
		for(Member mem:member){
			rowdata=rowdata.concat("<tr><td class=\"text-left\">"+mem.getId()+"</td><td class=\"text-left\">"+mem.getUserName()+"</td><td class=\"text-left\">"+mem.getPhoneNumber()+"</td></tr>");
		}

		transaction.commit();
		session.close();
		sessionFactory.close();
		return rowdata;
	}
	@SuppressWarnings("deprecation")
	public void removeUser(int id) {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		DatabaseServices databaseServices = new DatabaseServices();
		
		int memberId = id;
		Member member = (Member) session.get(Member.class, memberId);
		if(databaseServices.validateMemberId(memberId)){
			session.delete(member);		
		}else{
			ServiceMain.printAcknowledgeMessage("\nEnter Valid ID\n");
		}
		
		transaction.commit();
		member = (Member) session.get(Member.class, memberId);
		if(member == null)
			ServiceMain.printAcknowledgeMessage("\nUser Deleted Successfully\n");
		else
			ServiceMain.printAcknowledgeMessage("\nSomething went wrong\n");
		session.close();
		sessionFactory.close();

	}
	@SuppressWarnings("deprecation")
	public void updateUserDetails(int memberId,String userName,String password,String userPhoneNumber) {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		System.out.println("Update the Details of User");
		int id = memberId;
		Member member = (Member)session.get(Member.class, id);
		member.setUserName(userName);
		member.setUserPassword(password);
		member.setPhoneNumber(Long.parseLong(userPhoneNumber));
		session.saveOrUpdate(member);
		transaction.commit();
		ServiceMain.printAcknowledgeMessage("\nUser Updated Successfully\n");
		session.close();
		sessionFactory.close();
		

	}
	@SuppressWarnings("deprecation")
	public void addBook(String bookName,String authorNmae,String edition) {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Book book = new Book();
		//book.setBookId(serviceMain.intEntry("Book Id"));
		book.setBookName(bookName);
		book.setAuthor(authorNmae);
		book.setEdition(Integer.parseInt(edition));
		book.setRating(4);

		session.save(book);
		transaction.commit();
		ServiceMain.printAcknowledgeMessage("\nBook added successfully\n");
		session.close();
		sessionFactory.close();
	}
	@SuppressWarnings("deprecation")
	public void updateBookDetails(int bookId,String bookName,String authorNmae,String edition) {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Update the Details of User");
		int id = bookId;
		Book book = (Book)session.get(Book.class, id);
		book.setBookName(bookName);
		book.setAuthor(authorNmae);
		book.setEdition(Integer.parseInt(edition));
		book.setRating(4);
		
		session.saveOrUpdate(book);
		
		transaction.commit();
		ServiceMain.printAcknowledgeMessage("\nBook Updated Successfully\n");
		session.close();
		sessionFactory.close();

	}
	@SuppressWarnings("deprecation")
	public void removeBook(int id) {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		DatabaseServices databaseServices = new DatabaseServices();
		
		int bookId = id;
		Book book = (Book) session.get(Book.class, bookId);
		if(databaseServices.validateBookId(bookId)){
			session.delete(book);		
		}else{
			ServiceMain.printAcknowledgeMessage("\nEnter Valid ID\n");
		}
		
		transaction.commit();
		book = (Book) session.get(Book.class, bookId);
		if(book == null)
			ServiceMain.printAcknowledgeMessage("\nBook Deleted Successfully\n");
		else
			ServiceMain.printAcknowledgeMessage("\nSomething went wrong\n");
				
		session.close();
		sessionFactory.close();

	}
	@SuppressWarnings({"deprecation", "unchecked", "rawtypes"})
	public String displayBookDetails() {
		String rowdata="";
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Book.class);
		List<Book> book = criteria.list();
//		Iterator it = book.iterator();
//		while (it.hasNext()) {
//			
//			System.out.println(it.next());
//		}
		for(Book bk :book){
			String id =(bk.getMember() != null)? bk.getMember().getId()+"":"-";
			rowdata=rowdata.concat("<tr><td class=\"text-left\">"+bk.getBookId()+"</td><td class=\"text-left\">"+bk.getBookName()+"</td><td class=\"text-left\">"+bk.getEdition()+"</td><td class=\"text-left\">"+bk.getRating()+"</td><td class=\"text-left\">"+id+"</td></tr>");
		}

		transaction.commit();
		session.close();
		sessionFactory.close();
		return rowdata;
	}
	public Member searchByID(int id){
		
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Member member =(Member)session.get(Member.class, id);
		//print 
//		System.out.println(book);
		
		session.close();
		sessionFactory.close();
		return member;
	}
}