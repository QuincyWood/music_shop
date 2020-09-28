<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Artist Application</title>
</head>
<body>
    <center>
        <h1>Music Management</h1>
        <h2>
            <a href="<%=request.getContextPath()%>/new_2">Add New Artist</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list1">List All Artist</a>           
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Artist</h2></caption>
            <tr>
            	<th>ID</th>
                <th>Artist Name</th>
                <th>Song</th>
                <th>Price</th>
                <th>Year</th>
                <th>Actions</th>
                
            </tr>
            <c:forEach var="listArtist" items="${listArtist}">
                <tr>
                    <td><c:out value="${listArtist.id}" /></td>
                    <td><c:out value="${listArtist.artist_name}" /></td>
                    <td><c:out value="${listArtist.song}" /></td>
                    <td><c:out value="${listArtist.price}" /></td>
                    <td><c:out value="${listArtist.year}" /></td>
                    
                    <td>
                        <a href="<%=request.getContextPath()%>/edit_2?id=<c:out value='${listArtist.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/delete_2?id=<c:out value='${listArtist.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>