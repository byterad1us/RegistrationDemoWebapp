<%-- 
    Document   : index
    Created on : Nov 22, 2015, 3:12:09 PM
    Author     : ouvre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
           <c:choose>
                <c:when test="${sessionScope.REGISTERED}" >
                   Registered
                </c:when>    
                <c:otherwise>
                    Registration Failure
                </c:otherwise>
         </c:choose>
        </title>
        <link rel="stylesheet" type="text/css" href="css/pages.css" />
    </head>
    <body>
        <br /><br /><br />
         <c:choose>
                <c:when test="${sessionScope.REGISTERED}" >
                    <h1>Welcome <c:out value="${sessionScope.USER_ID}" /> !!</h1>
                </c:when>    
                <c:otherwise>
                    <h1>Registration Failed:  <c:out value="${sessionScope.ERROR}" /></h1>
                </c:otherwise>
         </c:choose>
    </body>
</html>
