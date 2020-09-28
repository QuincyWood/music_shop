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
            <a href="/ArtistServlet/new">Add New Artist</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/ArtistServlet/list">List All Artist</a>           
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Artist</h2></caption>
            <tr>
                <th>Artist Name</th>
                <th>Song</th>
                <th>Price</th>
                <th>Year</th>
                <th>Actions</th>
                
            </tr>
            <c:forEach var="artist" items="${listArtist}">
                <tr>
                    <td><c:out value="${artist.Artist_name}" /></td>
                    <td><c:out value="${artist.song}" /></td>
                    <td><c:out value="${artist.price}" /></td>
                    <td><c:out value="${artist.year}" /></td>
                    
                    <td>
                        <a href="/ArtistServlet/edit?id=<c:out value='${artist.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/ArtistServlet/delete?id=<c:out value='${artist.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>