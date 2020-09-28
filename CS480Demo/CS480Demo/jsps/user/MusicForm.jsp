<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Customer Application</title>
</head>
<body>
    <center>
        <h1>Music Management</h1>
        <h2>
            <a href="/MusicServlet/new">Add New Customers</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/MusicServlet/list">List All Customers</a>
             
        </h2>
    </center>
    <div align="center">
    
        <c:if test="${customers != null}">
            <form action="update" method="post">
        </c:if>
        
 		<c:if test="${customers == null}">
            <form action="insert" method="post">
       </c:if>
       
        <table border="1" cellpadding="5">
            <caption>
                   <h2>
                   		 <c:if test="${customers != null}">
                    
            Edit customers
                    </c:if>
                    <c:if test="${customers == null}">
                        Add New customers
                    </c:if>
                </h2>
            </caption>
            <tr>
                <th>customer_name: </th>
                <td>
                    <input type="text" name="customer_name" size="45"
                            value="<c:out value='${customers.customer_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${customers.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>id: </th>
                <td>
                    <input type="text" name="id" size="5"
                            value="<c:out value='${customers.id}' />"
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