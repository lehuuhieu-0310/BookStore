<%-- 
    Document   : create
    Created on : Jun 15, 2021, 12:24:40 AM
    Author     : lehuuhieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
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
        <hr>
        <div class="container">
            <p><h1>Create Page</h1></p>

        <c:set value="${requestScope.ERROR}" var="error" />
        <form action="CreateBookController" method="POST" enctype="multipart/form-data">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Book Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtBookName" value="${param.txtBookName}" maxlength="51">*
                    <font color="red">
                    ${error.bookNameError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Title</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtTitle" value="${param.txtTitle}" maxlength="51">*
                    <font color="red">
                    ${error.titleError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Image</label>
                <div class="col-sm-10">
                    <input type="file" name="file">*
                    <font color="red">
                    ${error.imagesError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Description</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtDescription" value="${param.txtDescription}" maxlength="256">*
                    <font color="red">
                    ${error.descriptionError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Price</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtPrice" value="${param.txtPrice}" maxlength="15">*
                    <font color="red">
                    ${error.priceError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Author</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtAuthor" value="${param.txtAuthor}" maxlength="51">*
                    <font color="red">
                    ${error.authorError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Quantity</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtQuantity" value="${param.txtQuantity}" maxlength="11">*
                    <font color="red">
                    ${error.quantityError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Category Name</label>
                <select class="custom-select col-sm-10" name="category">
                    <c:forEach items="${requestScope.CATEGORY}" var="category">
                        <option value="${category.categoryId}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" name="action" value="SignUpBook" class="btn btn-primary">Sign Up</button>
                </div>
            </div>
        </form>
        <a href="ListAllAdminController">Back</a>
    </div>
</body>
</html>
