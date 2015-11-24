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
         <link rel="stylesheet" href="http://cdn.sencha.com/ext/gpl/4.2.1/resources/css/ext-all.css">
         <link rel="stylesheet" href="css/pages.css">
         <script type="text/javascript" src="http://cdn.sencha.com/ext/gpl/4.2.1/ext-all-debug.js"></script>
         <script type="text/javascript">
             <c:if test="${not empty sessionScope.USER_DATA}" >
                var sessionUserJsobj = { firstName: "${sessionScope.USER_DATA.firstName}", lastName: "${sessionScope.USER_DATA.lastName}", address1:"${sessionScope.USER_DATA.address1}", address2:"${sessionScope.USER_DATA.address2}", city: "${sessionScope.USER_DATA.city}", state: "${sessionScope.USER_DATA.state}", zip: "${sessionScope.USER_DATA.zip}", country: "${sessionScope.USER_DATA.country}", regdate: '2015-11-22 00:00:00'};
            </c:if>
         </script>
         <script type="text/javascript" src="js/grid.js"></script>
         <title>Registered Users</title>
        <link rel="stylesheet" type="text/css" href="css/pages.css" />
    </head>
    <body>
        <br /><br /><br />       
    <center><h1> Registered Users</h1>
             <br /><br /><br /><br />
             <div id="results-grid"></div>
             <br /><br /><br /><br /><br /><br /><br />       <br /><br /><br /><br /><br /><br />       <br /><br /><br />
             <h3><a href="regform.html"></a></h3>
             
    </center>           
    </body>
</html>
