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
        <link rel="stylesheet" href="http://cdn.sencha.com/ext/gpl/4.2.1/resources/css/ext-all.css">
        <link rel="stylesheet" href="css/pages.css">
        <script type="text/javascript" src="http://cdn.sencha.com/ext/gpl/4.2.1/ext-all-debug.js"></script>
        <script type="text/javascript" src="js/confirmation.js"></script>
    </head>
    <body>
    <center>
        <div id="display-panel"></div>
        <br /><br /><br />
         <div id="display-panel-content" style="display:none;">
             <br /><br />
             <c:choose>
                <c:when test="${sessionScope.REGISTERED}" >
                    <br />
                    <h1>Welcome </h1>
                    <h3><c:out value="${sessionScope.USER_ID}" /> !</h3>
                </c:when>    
                <c:otherwise>
                    <h1>Registration Failed:  /></h1>
                    <br />   
                    <h3><c:out value="${sessionScope.ERROR}" /></h3>
                </c:otherwise>
             </c:choose>
         </div>
             <br /><br />
             <H3><a href="report.jsp">Registration Report</a></H3>
      </center>           
    </body>
</html>
