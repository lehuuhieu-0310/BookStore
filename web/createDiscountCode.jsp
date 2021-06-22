<%-- 
    Document   : createDiscountCode
    Created on : Jun 18, 2021, 5:52:16 PM
    Author     : lehuuhieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
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
        <h1>Create Discount Code</h1>
        <hr>
        <form action="MainController" method="POST">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Code: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtCode" value="${param.txtCode}">
                    <font color="red">
                    ${requestScope.ERROR.codeError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Value: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtValue" value="${param.txtValue}">
                    <font color="red">
                    ${requestScope.ERROR.valueError}
                    </font>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary" name="action" value="CreateDiscountCode">Create</button>
                </div>
            </div>
        </form>
        <a href="ListAllDiscountCodeController">Back</a>
    </div>
</body>
</html>
