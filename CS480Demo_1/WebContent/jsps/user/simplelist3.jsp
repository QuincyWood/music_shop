<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Simple Query Application</title>
</head>
<body>
    <center>
        <h1>Simple Query Management</h1>
        <h2>     
            <a href="<%=request.getContextPath()%>/list_Query3">List Query</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of event in Chicago</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Location</th>
                <th>Date Event</th>                
                
            </tr>
            <c:forEach var="listEvent" items="${listEvent}">
                <tr>
                    <td><c:out value="${listEvent.id}" /></td>
                     <td><c:out value="${listEvent.name}" /></td>  
                    <td><c:out value="${listEvent.location}" /></td>                   
                    <td><c:out value="${listEvent.date}" /></td>                 
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>