<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.virtusa.project.services.admin.AdminServices" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
	<meta charset="utf-8" />
	<title>Table Style</title>
	<link rel="stylesheet" href="css/tablecss.css"> 
	<meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
</head>

<body>
<%
		session = request.getSession(false);
	 	if( session ==null){
	 		request.getRequestDispatcher("index.html").forward(request,response);
	 	}else{
	 		out.print("Hello "+session.getAttribute("userType"));
	 	}
	%>
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
<div class="table-title">
<h3>Data Table</h3>
</div>
<table class="table-fill">
<thead>
<tr>
<th class="text-left">BookID</th>
<th class="text-left">Name</th>
<th class="text-left">Edition</th>
<th class="text-left">Rating</th>
<th class="text-left">IssuedBy</th>
</tr>
</thead>
<tbody class="table-hover">
<%
	AdminServices adminServices = new AdminServices();
	out.print(adminServices.displayBookDetails());
%>
</tbody>
</table>
  
</body>
</html>