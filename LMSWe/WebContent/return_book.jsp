<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="com.virtusa.project.services.book.BookServices"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Member Service</title>
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>
		<font color="#FF00FF" size="100">Library Management System</font>
	</h1>
	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#signup">Return Book</a></li>
		</ul>

		<div class="tab-content">
			<div id="signup">

				<form action="return_book.jsp" method="post">

					<div class="field-wrap">
						<label> Book ID<span class="req" name="name">*</span>
						</label> <input type="number" name="bookId" required autocomplete="off" />
					</div>
					<!--<p class="forgot"><a href="#">Forgot Password?</a></p>-->

					<button class="button button-block" />
					Return Book
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
	if (request.getParameter("bookId") != null) {
		String bookId = request.getParameter("bookId");
		BookServices bookServices = new BookServices();
		String str=bookServices.returnBook(Integer.parseInt(session.getValue("id")+""),Integer.parseInt(bookId));
		out.println(str);
	}
	%>
</body>
</html>