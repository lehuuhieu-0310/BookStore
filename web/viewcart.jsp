<%-- 
    Document   : viewcart
    Created on : Jun 16, 2021, 10:59:20 PM
    Author     : lehuuhieu
--%>

<%@page import="tblBook.CartObj"%>
<%@page import="tblBook.BookDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
            <c:set value="${sessionScope.CART}" var="cart"/>
            <font color="red">
            <p>
                ${requestScope.SUCCESS}
                ${requestScope.ERROR}
            </p>
            </font>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">Book Name</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cart.getCart().values()}" var="dto" varStatus="counter">
                    <form action="MainController" method="POST">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td>${dto.bookName}</td>
                            <td class="col col-sm-1">
                                <input type="hidden" name="txtBookId" value="${dto.bookId}">
                                <input type="text" name="txtQuantity" value="${dto.quantity}" class="form-control">
                            </td>
                            <td>${dto.price * dto.quantity}</td>
                            <td>
                                <button class="btn btn-primary" type="submit" name="action" value="UpdateCart">Update</button>
                                |
                                <a class="btn btn-danger" href="DeleteCartController?txtBookId=${dto.bookId}">Delete</a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                <form action="MainController" method="POST">
                    <tr>
                        <th scope="row" colspan="3">Code Discount:</th>
                        <td>
                            <input type="text" name="txtCode" class="form-control" value="${param.txtCode}">
                            <font color="red">
                            ${requestScope.ERROR_CODE}
                            ${requestScope.SUCCESS_CODE}
                            </font>
                        </td>
                        <td>
                            <button name="action" class="btn btn-success" value="ApplyCodeDiscount">Apply</button>
                        </td>
                    </tr>
                </form>
                <tr>
                    <th scope="row" colspan="3">Total Price:</th>
                    <td><b>${cart.getTotal() - requestScope.DISCOUNT}</b></td>
                    <td>
                        <a style="width: 250px" id="placeOrder" href="PlaceOrderController?txtTotal=${cart.getTotal() - requestScope.DISCOUNT}" class="btn btn-success">Place Order</a>
                    </td>
                </tr>
                </tbody>
            </table>

            <table class="table table-bordered">
            </table>

            <a href="ListAllUserController" style="padding-bottom: 20px">Back</a>
        </div>
        <c:set var="total" value="${(cart.getTotal() - requestScope.DISCOUNT) / 23000}"/>
        <script src="https://www.paypal.com/sdk/js?client-id=AZDugUJa9mUphIYSokYYpuhTa4DPlDAhFcftGAvmE20tcn6J4rTuIYOf7OoMYY4gJ7x4RoXizVYHs1he"></script>
        <script>
            paypal.Buttons({
                createOrder: function (data, actions) {
                    // This function sets up the details of the transaction, including the amount and line item details.
                    return actions.order.create({
                        purchase_units: [{
                                amount: {
                                    value: '<fmt:formatNumber value="${total}" maxFractionDigits="2"/>'.replace(',', '.')
                                }
                            }]
                    });
                },
                onApprove: function (data, actions) {
                    // This function captures the funds from the transaction.
                    return actions.order.capture().then(function (details) {
                        // This function shows a transaction success message to your buyer.
                        var url = "PlaceOrderController?txtTotal=${cart.getTotal() - requestScope.DISCOUNT}";
                        location.replace(url)
                    });
                }
            }).render('#placeOrder');
            //This function displays Smart Payment Buttons on your web page.
        </script>

    </body>
</html>
