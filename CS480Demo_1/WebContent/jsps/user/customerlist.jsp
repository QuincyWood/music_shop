<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Application</title>
</head>
<body>
    <center>
        <h1>Customer Management</h1>
        <h2>
            <a href="<%=request.getContextPath()%>/new">Add New customer</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list">List All customer</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of customer</h2></caption>
            <tr>
                <th>ID</th>
                <th>Customer_name</th>
                <th>Email</th>                
                <th>Actions</th>
            </tr>
            <c:forEach var="listCustomer" items="${listCustomer}">
                <tr>
                    <td><c:out value="${listCustomer.id}" /></td>
                    <td><c:out value="${listCustomer.customer_name}" /></td>                   
                    <td><c:out value="${listCustomer.email}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit?id=<c:out value='${listCustomer.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${listCustomer.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>