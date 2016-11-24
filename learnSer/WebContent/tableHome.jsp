<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.test.CallerMain" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Table Example</title>
        <style>
            table {
                width: 100%;
            }
            table, th, td {
                border-collapse: collapse;
                padding: 5px;
            }
            table.alt tr:nth-child(even) {
                background-color: #eee;
            }
            table.alt tr:nth-child(odd) {
                background-color: #fff;
            }            
        </style>
    </head>
    <body>
        <table class="alt">
            <tr>
                <th>User Idr</th>
                <th>User Name</th>
            </tr>
           <%
           CallerMain cm = new CallerMain();
           out.print(cm.printTab());
           
           %>
        </table>
    </body>
</html>