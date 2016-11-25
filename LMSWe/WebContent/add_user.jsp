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
			<li class="tab active"><a href="#signup">New Member</a></li>
		</ul>

		<div class="tab-content">
			<div id="signup">

				<form action="add_user.jsp" method="post">

					<div class="field-wrap">
						<label> Name<span class="req" name="name">*</span>
						</label> <input type="text" name="userName" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Phone No<span class="req" name="phone">*</span>
						</label> <input type="text" name="phoneNumber" required autocomplete="off"
							pattern="[0-9]{10}" title="Please Enter 10 Digit No." />
					</div>

					<div class="field-wrap">
						<label> Password<span class="req" name="password">*</span>
						</label> <input type="password" name="userPassword" required
							autocomplete="off"
							title="Must contain at least  one number and one uppercase and lowercase letter, and at least 8 or more characters" />
					</div>

					<!--<p class="forgot"><a href="#">Forgot Password?</a></p>-->

					<button class="button button-block" />
					Add Member
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
		if (request.getParameter("userName") != null) {
			String userName = request.getParameter("userName");
			String userPhoneNumber = request.getParameter("phoneNumber");
			String password = request.getParameter("userPassword");
			AdminServices adminServices = new AdminServices();
			adminServices.addUser(userName, password, userPhoneNumber);
		%>
		<h1><center><color="RED">User added Successfully</color></center> </h1>
		<% 
		}
	%>

</body>
</html>

<!-- pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" -->