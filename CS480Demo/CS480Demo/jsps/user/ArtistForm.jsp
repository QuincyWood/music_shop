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
    
        <c:if test="${artist != null}">
            <form action="update" method="post">
        </c:if>
        
 		<c:if test="${artist == null}">
            <form action="insert" method="post">
       </c:if>
       
        <table border="1" cellpadding="5">
            <caption>
                   <h2>
                   		 <c:if test="${artist != null}">
                    
            Edit Artist
                    </c:if>
                    <c:if test="${artist == null}">
                        Add New Artist
                    </c:if>
                </h2>
            </caption>
            <tr>
                <th>artist_name: </th>
                <td>
                    <input type="text" name="artist_name" size="45"
                            value="<c:out value='${artist.artist_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>email: </th>
                <td>
                    <input type="text" name="song" size="45"
                            value="<c:out value='${artist.song}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${artist.price}' />"
                    />
                </td>
            </tr>
            <tr>
            <th>year: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${artist.year}' />"
                    />
                </td>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>