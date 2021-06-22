<%-- 
    Document   : listAllCategory
    Created on : Jun 15, 2021, 9:05:02 PM
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
    <body >
        <c:if test="${sessionScope.ROLE ne 'admin'}">
            <c:redirect url="ListAllUserController"/>
        </c:if>
        <c:if test="${sessionScope.USERNAME == null}">
            <c:redirect url="login.html"/>
        </c:if>
        <jsp:include page="headerAdmin.jsp"/>
        <div class="container">
            <h1>List All Category</h1>
            <p>
                <a href="createCategory.jsp">Create Category</a>
            </p>
            <hr>
            <font color="red">
            <p>
                ${requestScope.SUCCESS}
            </p>
            </font>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">CategoryName</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <form action="" method="POST">
                    <c:forEach items="${requestScope.LIST}" var="dto" varStatus="counter">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td><input type="text" name="txtCategoryName" value="${dto.categoryName}" class="form-control">
                                <font color="red">
                                ${requestScope.ERROR.categoryNameError}
                                </font>
                            </td>
                            <td class="col-sm-3">
                                <a class="btn btn-primary" href="DeleteCategoryController?txtCategoryId=${dto.categoryId}">Delete</a> |
                                <a class="btn btn-danger" href="FindCategoryController?txtCategoryId=${dto.categoryId}">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </form>
            </table>
            <a href="ListAllAdminController">Back</a>
        </div>
    </body>
</html>
