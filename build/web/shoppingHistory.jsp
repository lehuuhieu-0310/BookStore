<%-- 
    Document   : shoppingHistory
    Created on : Jun 18, 2021, 9:43:34 AM
    Author     : lehuuhieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.ROLE ne 'user'}">
            <c:redirect url="ListAllAdminController"/>
        </c:if>
        <jsp:include page="headerUser.jsp"/>
        <hr>
        <div class="container">
            <h1>Shopping History</h1>
            <hr>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">User name</th>
                        <th scope="col">Total</th>
                        <th scope="col">Date Order</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.LIST}" var="list" varStatus="counter">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td>${list.username}</td>
                            <td>${list.total}</td>
                            <td>${list.dateOrder}</td>
                            <td>
                                <a class="btn btn-success" href="OrderDetailController?txtOrderId=${list.orderId}">Detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="ListAllUserController">Back</a>
        </div>
    </body>
</html>
