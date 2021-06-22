<%-- 
    Document   : manageDiscountCode
    Created on : Jun 18, 2021, 5:44:55 PM
    Author     : lehuuhieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    </head>
    <body >
        <c:if test="${sessionScope.ROLE ne 'admin'}">
            <c:redirect url="ListAllUserController"/>
        </c:if>
        <c:if test="${sessionScope.USERNAME == null}">
            <c:redirect url="login.html"/>
        </c:if>
        <jsp:include page="headerAdmin.jsp"/>
        <div class="container">
            <h1>Manage Discount Code</h1>
            <p>
                <a href="createDiscountCode.jsp">Create discount code</a>
            </p>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">Code</th>
                        <th scope="col">Value</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.LIST}" var="list" varStatus="counter">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td>${list.code}</td>
                            <td>${list.value}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="ListAllAdminController">Back</a>
        </div>
    </body>
</html>
