<%-- 
    Document   : admin
    Created on : Jun 14, 2021, 11:39:41 AM
    Author     : lehuuhieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.ROLE ne 'admin'}">
            <c:redirect url="ListAllUserController"/>
        </c:if>
        <c:if test="${sessionScope.USERNAME == null}">
            <c:redirect url="login.html"/>
        </c:if>
        <!--header-->

        <jsp:include page="headerAdmin.jsp"/>
        <hr>

        <div class="container">
            <p>
                <a href="ListCategoryNameController">Create Book</a>
            </p>
            <p>
                <a href="ListAllCategoryController">Manage Category</a>
            </p>
            <p>
                <a href="ListAllAdminController">Refresh</a>
            </p>
            <p>
                <a href="ListAllDiscountCodeController">Manage Discount Code</a>
            </p>
            <font color="red">
            <p>${requestScope.SUCCESS}</p>
            </font>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">Book Name</th>
                        <th scope="col">Title</th>
                        <th scope="col">Image</th>
                        <th scope="col">Description</th>
                        <th scope="col">Price</th>
                        <th scope="col">Author</th>
                        <th scope="col">Import Date</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Status</th>
                        <th scope="col">Category Name</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.LIST}" var="list" varStatus="counter">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td>${list.bookName}</td>
                            <td>${list.title}</td>
                            <td>
                                <c:if test="${not empty list.image}">
                                    <img src="images/${list.image}" width="200px">
                                </c:if>
                            </td>
                            <td>${list.description}</td>
                            <td>${list.price}</td>
                            <td>${list.author}</td>
                            <td>${list.importDate}</td>
                            <td>${list.quantity}</td>
                            <td>${list.status}</td>
                            <td>${list.categoryName}</td>
                            <td>
                                <a class="btn btn-primary" href="FindBookController?txtBookId=${list.bookId}">Update</a><br><br>
                                <a class="btn btn-danger" href="DeleteBookController?txtBookId=${list.bookId}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!--footer-->
        <div class="navbar navbar-dark bg-dark" style="padding: 2%">
        </div>
    </body>
</html>
