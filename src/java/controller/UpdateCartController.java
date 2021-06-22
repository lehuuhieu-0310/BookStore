/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblBook.BookDAO;
import tblBook.CartObj;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "UpdateCartController", urlPatterns = {"/UpdateCartController"})
public class UpdateCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "error.jsp";
        try {
            boolean valid = true;
            BookDAO dao = new BookDAO();
            String bookIdTemp = request.getParameter("txtBookId");
            int bookId = Integer.parseInt(bookIdTemp);
            String newQuantityTemp = request.getParameter("txtQuantity");
            int newQuantity = -1;
            if (newQuantityTemp.isEmpty()) {
                valid = false;
                request.setAttribute("ERROR", "Quantity can't be blank");
            } else {
                newQuantity = Integer.parseInt(newQuantityTemp);
                int checkQuantity = dao.checkQuantity(bookId);
                if (newQuantity > checkQuantity) {
                    valid = false;
                    request.setAttribute("ERROR", "Quantity must <= " + checkQuantity);
                }
            }
            if (valid) {
                HttpSession session = request.getSession();
                CartObj shoppingCart = (CartObj) session.getAttribute("CART");
                shoppingCart.update(bookId, newQuantity);
                session.setAttribute("CART", shoppingCart);
                request.setAttribute("SUCCESS", "Update cart successfully");
            }
            url = "viewcart.jsp";
        } catch (Exception e) {
            log("ERROR at FindBookCartController: " + e.getMessage());
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
