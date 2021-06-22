<%-- 
    Document   : checkout
    Created on : Jun 18, 2021, 12:37:46 AM
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${sessionScope.ROLE ne 'user'}">
        <c:redirect url="ListAllAdminController"/>
    </c:if>
    <h1>Payment successfully</h1>
    <hr>
    <a href="ListAllUserController">Back</a>
</body>
</html>
