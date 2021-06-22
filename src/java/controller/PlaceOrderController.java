/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblBook.BookDTO;
import tblBook.CartObj;
import tblOrder.OrderDAO;
import tblOrderDetail.OrderDetailDAO;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "PlaceOrderController", urlPatterns = {"/PlaceOrderController"})
public class PlaceOrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "error.jsp";
        try {
            HttpSession session = request.getSession();
            CartObj shoppingCart = (CartObj) session.getAttribute("CART");
            if (shoppingCart == null || shoppingCart.getCart().isEmpty()) {
                request.setAttribute("ERROR", "Cart is empty");
                url = "viewcart.jsp";
            } else {
                log("cart: " + shoppingCart.getCart().values());

                String totalTemp = request.getParameter("txtTotal");
                float total = Float.valueOf(totalTemp);
                String username = shoppingCart.getUsername();
                Date dateOrder = Date.valueOf(LocalDate.now());
                OrderDAO orderDAO = new OrderDAO();
                int orderId = orderDAO.addOrder(username, total, dateOrder);
                for (BookDTO x : shoppingCart.getCart().values()) {
                    int bookId = x.getBookId();
                    int quantity = x.getQuantity();
                    float price = x.getPrice();
                    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                    orderDetailDAO.add(orderId, bookId, quantity, price);
                }
                shoppingCart.getCart().clear();
                url = "checkout.jsp";
                log("cart: " + shoppingCart);
            }
        } catch (Exception e) {
            log("ERROR at PlaceOrderController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
