<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "org.hibernate.cfg.Configuration, org.hibernate.*,com.virtusa.project.services.database.DatabaseServices"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
<%-- <jsp:param value="" name="adminid"/> --%>
 <%
	session = request.getSession();
 	session.getValue("id");
%>
<table>
<th> <a href="issue_book.jsp">Issue Book</a><br/></th>
<th> <a href="return_book.jsp">Return Book</a><br/></th>
<th> <a href="view_book.jsp">view Book List</a><br/></th>
<th> <a href="display_user.jsp">Search Book List</a><br/></th>
</table>
</body>
</html>