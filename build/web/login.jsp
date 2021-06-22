<%-- 
    Document   : login
    Created on : May 11, 2021, 9:44:53 PM
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

        <title>JSP Page</title>
         <!--reCAPTCHA with Auto language--> 
        <script src='https://www.google.com/recaptcha/api.js'></script>
    </head>
    <body>
        <div class="container" style="text-align: center">
            <h1>Login Page</h1>
            <hr>
            <form action="loginController" method="POST" class="form-group">
                <table style="margin: auto">
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="txtUsername" value="${param.txtUsername}" class="form-control"/></td>
                        <td style="color: red">${requestScope.INVALID.usernameError}</td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="txtPassword" class="form-control"/></td>
                        <td style="color: red">${requestScope.INVALID.passwordError}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><div class="g-recaptcha" data-sitekey="6LdlboMaAAAAAPT3EZhDaMsPMhLL07SDAdHvBcTL"/></td>
                        <td style="color: red">${requestScope.INVALID.recaptchaError}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Login" class="btn btn-primary"/></td>
                    </tr>

                </table>
            </form>
        </div>
    </body>
</html>
