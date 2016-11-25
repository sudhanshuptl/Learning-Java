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
	int memberId = Integer.parseInt(request.getParameter("memberid"));
	String memberPassword = request.getParameter("memberpassword");
	/* Configuration configuration = new Configuration();
	configuration.configure("hibernate.cfg.xml"); 
	Configuration cfg = DatabaseServices.config();
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	Session session1 = sessionFactory.openSession();
	Transaction transaction = session1.beginTransaction();*/
	DatabaseServices dbs = new DatabaseServices();
	if(dbs.authenticateMember(memberId,memberPassword)){
		session = request.getSession();
		session.setAttribute("id", memberId);
		//session.setAttribute("userType", "admin"); 
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("member_home_page.jsp");
		requestDispatcher.include(request, response);
	}
%>
</body>
</html>