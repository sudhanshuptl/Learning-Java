<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form  action="storeDynamicform" method="POST" modelAttribute="userBean">
<form:errors path="*"/><%--  All error at one place--%></br></br></br>
<!-- Note : modelAttribute="userBean" then only it work if class is UserBean -->
 User Name: <form:input type="text " path="name"/><form:errors path="name"/></br>
 Password : <form:input type="password" path="pass"/><form:errors path="pass"/></br>
 <tr>
 <td> </br>programming Language :</td> </br>
 <td>
 <form:checkboxes items="${pl}" path="pl"/><form:errors path="pl"/></br>
 </td>
 </tr>
 <!-- Now it directly map values to UserBean object and pass data as object -->
<input type="submit" value="Submit">
 </form:form>
</body>
</html>