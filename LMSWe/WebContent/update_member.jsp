<%@page
	import="com.virtusa.project.services.book.BookServices,org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.Transaction,org.hibernate.cfg.Configuration"%>
<%@page
	import="com.virtusa.project.books.Book,com.virtusa.project.services.database.*,com.virtusa.project.users.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.virtusa.project.services.admin.AdminServices"%>
<!DOCTYPE html>
<html>
<head>
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
		String memberName = null;
		String password = null;
		long phoneNumber = 0;
		AdminServices adminServices = new AdminServices();
		if (request.getParameter("memberId") != null) {
			Member member = adminServices.searchByID(Integer.parseInt(request.getParameter("memberId")));
			memberName = member.getUserName();
			password= member.getUserPassword();
			phoneNumber = member.getPhoneNumber();
		}
	%>

	<h1>
		<font color="#FF00FF" size="100">Library Management System</font>
	</h1>
	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#signup">Update Member</a></li>
		</ul>

		<div class="tab-content">
			<div id="signup">

				<form action="update_member2.jsp" method="post">
				<input type="hidden" name="memberId" value=<%= request.getParameter("memberId") %>>

					<div class="field-wrap">
						<!-- <label> Book Name<span class="req" name="bookName">*</span> -->
						User Name </label> <input type="text" name="userName" value=<%=memberName%> />
					</div>

					<div class="field-wrap">
						<!-- <label> Author<span class="req" name="Author">*</span> -->
						Password </label> <input type="password" name="password" value=<%=password%> />
					</div>

					<div class="field-wrap">
						<!-- <label> Edition<span class="req" name="edition">*</span> -->
						Phone Number </label> <input type="number" name="phoneNumber" value=<%=phoneNumber%> />
					</div>


					<!--<p class="forgot"><a href="#">Forgot Password?</a></p>-->

					<button class="button button-block" />
					Update
					</button>

				</form>

			</div>
		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>
</body>
</html>

<!-- pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" -->