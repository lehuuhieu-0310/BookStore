<%-- 
    Document   : updateCategory
    Created on : Jun 15, 2021, 9:42:40 PM
    Author     : lehuuhieu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.ROLE ne 'admin'}">
            <c:redirect url="ListAllAdminController"/>
        </c:if>
        <c:if test="${sessionScope.USERNAME == null}">
            <c:redirect url="login.html"/>
        </c:if>
        <jsp:include page="headerAdmin.jsp"/>
        <div class="container">
            <h1>Update Category Page</h1>
            <hr>
            <form action="MainController" method="POST">
                <c:set value="${requestScope.DTO}" var="dto"/>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Category Name</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="txtCategoryId" value="${dto.categoryId}">
                        <input type="text" class="form-control" value="${dto.categoryName}" name="txtCategoryName">
                        <font color="red">
                        ${requestScope.ERROR.categoryNameError}
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary" value="UpdateCategory" name="action">Update</button>
                    </div>
                </div>
            </form>
            <a href="ListAllCategoryController">Back</a>
        </div>
    </body>
</html>
