<%-- 
    Document   : update
    Created on : Jun 15, 2021, 8:50:54 AM
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
            <h1>Update Page</h1>
            <hr>
            <c:set var="dto" value="${requestScope.DTO}"/>
            <c:set var="error" value="${requestScope.ERROR}"/>
            <form action="UpdateBookController" method="POST" enctype="multipart/form-data">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Book Name</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="txtBookId" value="${not empty dto.bookId ? dto.bookId : param.txtBookId}">
                        <input type="text" class="form-control" name="txtBookName" value="${not empty dto.bookName ? dto.bookName : param.txtBookName}">
                        <font color="red">
                        ${error.bookNameError}
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Title</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtTitle" value="${not empty dto.title ? dto.title : param.txtTitle}">
                        <font color="red">
                        ${error.titleError}
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Image</label>
                    <div class="col-sm-10">
                        <c:if test="${not empty dto.image}">
                            <img src="images/${dto.image}" width="300px" >
                        </c:if>
                        <c:if test="${not empty param.txtFile}">
                            <img src="images/${param.txtFile}" width="300px">
                        </c:if>
                        <input type="file" name="file">
                        <br>
                        <input type="hidden" name="txtFile" value="${not empty dto.image ? dto.image : param.txtFile}">
                        <font color="red">
                        ${error.imagesError}    
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Description</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtDescription" value="${not empty dto.description ? dto.description : param.txtDescription}">
                        <font color="red">
                        ${error.descriptionError}
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Price</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtPrice" value="${not empty dto.price ? dto.price : param.txtPrice}">
                        <font color="red">
                        ${error.priceError}
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Author</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtAuthor" value="${not empty dto.author ? dto.author : param.txtAuthor}">
                        <font color="red">
                        ${error.authorError}
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Import Date</label>
                    <div class="col-sm-3">
                        <input type="date" class="form-control" name="txtImportDate" value="${not empty dto.importDate ? dto.importDate : param.txtImportDate}">
                        <font color="red">
                        ${error.importDateError}
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Quantity</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtQuantity" value="${not empty dto.quantity ? dto.quantity : param.txtQuantity}">
                        <font color="red">
                        ${error.quantityError}
                        </font>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Category Name</label>
                    <select class="custom-select col-sm-10" name="category">
                        <c:forEach items="${requestScope.CATEGORY}" var="category">
                            <option value="${category.categoryId}" 
                                    <c:if test="${category.categoryId eq dto.categoryId}">
                                        selected
                                    </c:if>
                                    >${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" name="action" value="UpdateBook" class="btn btn-primary">Update</button>
                    </div>
                </div>
            </form>
            <a href="ListAllAdminController">Back</a>
        </div>
    </body>
</body>
</html>
