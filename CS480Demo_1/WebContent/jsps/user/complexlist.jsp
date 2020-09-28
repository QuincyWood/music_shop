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
            <a href="<%=request.getContextPath()%>/new">Add New customer</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list_Com_Query">List All customer</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of customer named Keith</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>   
                <th>ID</th>
                <th>Artist Name</th>
                <th>Song</th>
                <th>Price</th>
                <th>Year</th>
                <th>Actions</th>                       
            </tr>
             
            <c:forEach var="listCustomer," items="${listCustomer}">
        	<c:forEach var="listArtist," items="${listArtist}">
                <tr>
                    <td><c:out value="${listCustomer.id}" /></td>
                    <td><c:out value="${listCustomer.customer_name}" /></td>                   
                    <td><c:out value="${listCustomer.email}" /></td>
                    <td><c:out value="${listArtist.id}" /></td>
                    <td><c:out value="${listArtist.artist_name}" /></td>
                    <td><c:out value="${listArtist.song}" /></td>
                    <td><c:out value="${listArtist.price}" /></td>
                    <td><c:out value="${listArtist.year}" /></td>
                </tr>
            </c:forEach>
             </c:forEach>
        </table>
    </div>   
</body>
</html>