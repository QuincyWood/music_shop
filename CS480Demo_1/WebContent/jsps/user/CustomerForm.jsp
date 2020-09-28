<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Application</title>
</head>
<body>
    <center>
        <h1>Customer Management</h1>
        <h2>
            <a href="<%=request.getContextPath()%>/new">Add New Customer</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list">List All Customer</a>
             
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
                        Edit Customer
                    </c:if>
                    <c:if test="${customers == null}">
                        Add New Customer
                    </c:if>
                </h2>
            </caption>
                <c:if test="${customers != null}">
                    <input type="hidden" name="id" value="<c:out value='${customers.id}' />" />
                </c:if>           
            <tr>
                <th>Customer_name: </th>
                <td>
                    <input type="text" name="customer_name" size="45"
                            value="<c:out value='${customers.customer_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${customers.email}' />"
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