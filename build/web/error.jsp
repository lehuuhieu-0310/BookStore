<%-- 
    Document   : error
    Created on : Jun 14, 2021, 10:43:20 AM
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
        <h1>Error Page</h1>
        <font color="red">
        <h1>
            ${requestScope.ERROR}
        </h1>
        </font>
        <hr>
        <a href="login.html">Back to login</a>
    </body>
</html>
