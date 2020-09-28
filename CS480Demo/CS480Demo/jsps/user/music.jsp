<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Customer Store Application</title>
</head>
<body>
    <center>
        <h1>Customer Management</h1>
        <h2>
            <a href="/MusicServlet/new">Add New Customers</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/MusicServlet/list">List All Customers</a>           
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of customers</h2></caption>
            <tr>
                <th>Customer Name</th>
                <th>Email</th>
                <th>ID</th>
                <th>Actions</th>
                
            </tr>
            <c:forEach var="customers" items="${listMusic}">
                <tr>
                    <td><c:out value="${customers.customer_name}" /></td>
                    <td><c:out value="${customers.email}" /></td>
                    <td><c:out value="${customers.id}" /></td>
                    
                    <td>
                        <a href="/MusicServlet/edit?id=<c:out value='${customers.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/MusicServlet/delete?id=<c:out value='${customers.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>