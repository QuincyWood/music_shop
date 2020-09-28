<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Event Application</title>
</head>
<body>
    <center>
        <h1>Event Management</h1>
        <h2>
            <a href="/EventServlet/new">Add New Event</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/EventServlet/list">List All Event</a>           
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Event</h2></caption>
            <tr>
                <th>location</th>
                <th>Date</th>
                <th>ticket id</th>
                <th>Actions</th>
                
            </tr>
            <c:forEach var="event" items="${listEvent}">
                <tr>
                    <td><c:out value="${event.location}" /></td>
                    <td><c:out value="${event.date_event}" /></td>
                    <td><c:out value="${event.ticket_id}" /></td>
                    
                    <td>
                        <a href="/EventServlet/edit?id=<c:out value='${event.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/EventServlet/delete?id=<c:out value='${event.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>