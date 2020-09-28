<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Simple Query Application</title>
</head>
<body>
    <center>
        <h1>Simple Query Management</h1>
        <h2>
        
            <a href="<%=request.getContextPath()%>/list_Query2">List Query</a>           
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Artist hits in 2017</h2></caption>
            <tr>
            	<th>ID</th>
                <th>Artist Name</th>
                <th>Song</th>
                <th>Price</th>
                <th>Year</th>
              
                
            </tr>
            <c:forEach var="listArtist" items="${listArtist}">
                <tr>
                    <td><c:out value="${listArtist.id}" /></td>
                    <td><c:out value="${listArtist.artist_name}" /></td>
                    <td><c:out value="${listArtist.song}" /></td>
                    <td><c:out value="${listArtist.price}" /></td>
                    <td><c:out value="${listArtist.year}" /></td>
                    
                    
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>