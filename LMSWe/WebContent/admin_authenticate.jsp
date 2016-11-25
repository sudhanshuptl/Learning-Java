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
	int adminId = Integer.parseInt(request.getParameter("adminid"));
	String adminPassword = request.getParameter("adminpassword");
	/* Configuration configuration = new Configuration();
	configuration.configure("hibernate.cfg.xml"); 
	Configuration cfg = DatabaseServices.config();
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	Session session1 = sessionFactory.openSession();
	Transaction transaction = session1.beginTransaction();*/
	DatabaseServices dbs = new DatabaseServices();
	if(dbs.authenticateAdmin(adminId, adminPassword)){
		session = request.getSession();
		session.setAttribute("id", adminId);
		session.setAttribute("userType", "admin"); 
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin_home_page.jsp");
		requestDispatcher.include(request, response);
	}
%>
</body>
</html>