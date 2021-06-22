<%-- 
    Document   : orderDetail
    Created on : Jun 18, 2021, 2:07:33 PM
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
            <h1>Order Detail</h1>
            <hr>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">Book Name</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.LIST}" var="list" varStatus="counter">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td>${list.bookName}</td>
                            <td>${list.quantity}</td>
                            <td>${list.price}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="ShoppingHistoryController">Back</a>
        </div>
    </body>
</html>
