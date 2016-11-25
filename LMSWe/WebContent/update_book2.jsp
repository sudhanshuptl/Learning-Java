<%@page
	import="com.virtusa.project.services.book.BookServices,org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.Transaction,org.hibernate.cfg.Configuration"%>
<%@page
	import="com.virtusa.project.books.Book,com.virtusa.project.services.database.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.virtusa.project.services.admin.AdminServices,org.hibernate.cfg.Configuration, org.hibernate.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/tablecss.css"> 
<meta charset="UTF-8">
<title>Admin Service</title>
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


<link rel="stylesheet" href="css/style.css">


</head>

<body>
<table>
<th> <a href="add_user.jsp">Add User</a><br/></th>
<th> <a href="update_member_by_id.jsp">Update User Details</a><br/></th>
<th> <a href="remove_user.jsp">Remove User</a><br/></th>
<th> <a href="display_user.jsp">Display User Details</a><br/></th>
<th> <a href="add_book.jsp">Add Book</a><br/></th>
<th> <a href="update_book_by_id.jsp">Update Book Details</a><br/></th>
<th> <a href="remove_book.jsp">Remove Book</a><br/></th>
<th> <a href="display_book.jsp">Display Book Details</a><br/></th>
</table>

	<%
		out.print(request.getParameter("bookId") + "<br />"+request.getParameter("bookName")+ "<br />");
	if (request.getParameter("bookName") != null) {
		String fbookName = request.getParameter("bookName");
		String fauthorName = request.getParameter("authorName");
		String fedition = request.getParameter("edition");
		AdminServices adminServices = new AdminServices();
		adminServices.updateBookDetails(Integer.parseInt(request.getParameter("bookId")), fbookName,
				fauthorName, fedition);
		RequestDispatcher rd = request.getRequestDispatcher("display_book.jsp");
		rd.forward(request, response);
		
	}
		
	%>


</body>
</html>

<!-- pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" -->