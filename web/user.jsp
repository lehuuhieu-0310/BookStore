<%-- 
    Document   : user
    Created on : Jun 14, 2021, 11:39:28 AM
    Author     : lehuuhieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="headerUser.jsp"/>
        <hr>

        <div style="text-align: center">
            <font color="red">
            ${requestScope.SUCCESS}
            ${requestScope.ERROR}
            </font>
            <div>
                <form action="MainController" method="POST">
                    <p>
                        Search by name: <input type="text" name="txtBookName" value="${param.txtBookName}">
                        Search by money: <input type="text" name="txtMoney1" placeholder="From" value="${param.txtMoney1}">
                        <input type="text" name="txtMoney2" placeholder="To" value="${param.txtMoney2}">
                        Search by category: <input type="text" name="txtCategory" value="${param.txtCategory}">
                        <button type="submit" value="SearchIndexUser" name="action" class="btn btn-primary">Search</button>
                    </p>
                </form>
            </div>
            <h1>List Book</h1>
            <c:if test="${requestScope.LIST ne NULL}">
                <c:if test="${not empty requestScope.LIST}" var="checkList">
                    <div class="container">
                        <div class="row" style="text-align: center;">
                            <c:forEach items="${requestScope.LIST}" var="list">
                                <div class="card m-3 border-dark" style="width: 20rem">
                                    <div class="col ">
                                        <c:if test="${not empty list.image}">
                                            <img src="images/${list.image}" class="card-img-top mt-2">
                                        </c:if>
                                        <div class="card-body" style="text-align: left">
                                            <p><b>Name:</b> ${list.bookName}<p>
                                            <p><b>Title:</b> ${list.title}<p>
                                            <p><b>Description:</b> ${list.description}</p>
                                            <p><b>Author:</b> ${list.author}</p>
                                            <p><b>Category:</b> ${list.categoryName}</p>
                                            <p><b>Quantity:</b> ${list.quantity}</p>
                                            <span>
                                                <b>Price:</b> 
                                                <font color="red">
                                                ${list.price} |
                                                </font>
                                                <span class="fas fa-shopping-cart" style="color: #007bff"></span>
                                                <a href="AddCartController?txtBookId=${list.bookId}"> Add to cart</a>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>
                <c:if test="${!checkList}">
                    <font color="red">
                    No record found
                    </font>
                </c:if>
            </c:if>
        </div>
        <div class="navbar navbar-dark bg-dark" style="padding: 2%">
        </div>
    </body>
</html>
