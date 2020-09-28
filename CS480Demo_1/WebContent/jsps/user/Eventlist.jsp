<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Event Application</title>
</head>
<body>
    <center>
        <h1>Event Management</h1>
        <h2>
            <a href="<%=request.getContextPath()%>/new_3">Add New Event</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list2">List All Event</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of event</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Location</th>
                <th>Date Event</th>                
                <th>Actions</th>
            </tr>
            <c:forEach var="listEvent" items="${listEvent}">
                <tr>
                    <td><c:out value="${listEvent.id}" /></td>
                     <td><c:out value="${listEvent.name}" /></td>  
                    <td><c:out value="${listEvent.location}" /></td>                   
                    <td><c:out value="${listEvent.date}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit_3?id=<c:out value='${listEvent.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/delete_3?id=<c:out value='${listEvent.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>