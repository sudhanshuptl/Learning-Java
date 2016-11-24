<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>JSTL c:if Tag Example</title>
</head>
<body>
<c:set var="age" value="26"/>
<c:if test="${age >= 18}">
 <c:out value="You are eligible for voting!"/>
</c:if>
<c:if test="${age < 18}">
 <c:out value="You are not eligible for voting!"/>
</c:if>
</body>
</html>
</html>