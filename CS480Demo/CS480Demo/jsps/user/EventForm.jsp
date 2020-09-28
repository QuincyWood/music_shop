<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Event  Application</title>
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
    
        <c:if test="${event != null}">
            <form action="update" method="post">
        </c:if>
        
 		<c:if test="${event == null}">
            <form action="insert" method="post">
       </c:if>
       
        <table border="1" cellpadding="5">
            <caption>
                   <h2>
                   		 <c:if test="${event != null}">
                    
            Edit Artist
                    </c:if>
                    <c:if test="${event == null}">
                        Add New Event
                    </c:if>
                </h2>
            </caption>
            <tr>
                <th>artist_name: </th>
                <td>
                    <input type="text" name="location" size="45"
                            value="<c:out value='${event.location}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Date: </th>
                <td>
                    <input type="text" name="date_event" size="45"
                            value="<c:out value='${event.date_event}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ticket id: </th>
                <td>
                    <input type="text" name="ticket_id" size="5"
                            value="<c:out value='${artist.ticket_id}' />"
                    />
                </td>
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