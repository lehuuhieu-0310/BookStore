<%-- 
    Document   : createCategory
    Created on : Jun 15, 2021, 12:45:58 AM
    Author     : lehuuhieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${sessionScope.ROLE ne 'admin'}">
        <c:redirect url="ListAllUserController"/>
    </c:if>
    <c:if test="${sessionScope.USERNAME == null}">
        <c:redirect url="login.html"/>
    </c:if>
    <jsp:include page="headerAdmin.jsp"/>
    <div class="container">
        <h1>Create Category Page</h1>
        <hr>
        <form action="MainController" method="POST">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Category Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtCategoryName" maxlength="51">
                    <font color="red">
                    ${requestScope.ERROR.categoryNameError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Sign up</button>
                </div>
            </div>
        </form>
        <a href="ListAllCategoryController">Back</a>
    </div>
</body>
</html>
