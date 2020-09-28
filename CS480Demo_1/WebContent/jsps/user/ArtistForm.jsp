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
    
        <c:if test="${artist != null}">
            <form action="update_2" method="post">
        </c:if>
        
 		<c:if test="${artist == null}">
            <form action="insert_2" method="post">
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
            <c:if test="${artist != null}">
                    <input type="hidden" name="id" value="<c:out value='${artist.id}' />" />
                </c:if>     
            <tr>
                <th>artist name: </th>
                <td>
                    <input type="text" name="Name" size="45"
                            value="<c:out value='${artist.artist_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Song: </th>
                <td>
                    <input type="text" name="Song" size="45"
                            value="<c:out value='${artist.song}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="Price" size="5"
                            value="<c:out value='${artist.price}' />"
                    />
                </td>
            </tr>
            <tr>
            <th>Year: </th>
                <td>
                    <input type="text" name="Year" size="5"
                            value="<c:out value='${artist.year}' />"
                     />
                </td>
            </tr>
               
            
            <tr>
               
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>