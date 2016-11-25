<%@page import="com.virtusa.project.services.database.DatabaseServices"%>
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
	<h1>
		<font color="#FF00FF" size="100">Library Management System</font>
	</h1>
	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#signup">Check Member ID</a></li>
		</ul>

		<div class="tab-content">
			<div id="signup">

				<form action="update_member_by_id.jsp" method="post">

					<div class="field-wrap">
						<label> Member ID<span class="req" name="name">*</span>
						</label> <input type="number" name="memberId" required autocomplete="off" />
					</div>
					<!--<p class="forgot"><a href="#">Forgot Password?</a></p>-->

					<button class="button button-block" />
					Check Member ID
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
	<%
		if (request.getParameter("memberId") != null) {
			String memberId = request.getParameter("memberId");
			DatabaseServices databaseServices = new DatabaseServices();
			if(databaseServices.validateMemberId(Integer.parseInt(memberId))){
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("update_member.jsp");
				requestDispatcher.forward(request, response);
			}else{
				out.print("Not a valid member id");
			}
			
		}
	%>
</body>
</html>

<!-- pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" -->