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
        <c:if test="${event != null}">
            <form action="update_3" method="post">
        </c:if>
        <c:if test="${event == null}">
            <form action="insert_3" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${event != null}">
                        Edit Event
                    </c:if>
                    <c:if test="${event == null}">
                        Add New Event
                    </c:if>
                </h2>
            </caption>
                <c:if test="${event != null}">
                    <input type="hidden" name="id" value="<c:out value='${event.id}' />" />
                </c:if>        
                
                 <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="Name" size="45"
                            value="<c:out value='${event.name}' />"
                        />
                </td>
            </tr>   
            <tr>
                <th>Location: </th>
                <td>
                    <input type="text" name="Location" size="45"
                            value="<c:out value='${event.location}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Date: </th>
                <td>
                    <input type="text" name="date" size="45"
                            value="<c:out value='${event.date}' />"
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