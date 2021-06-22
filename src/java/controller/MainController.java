/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lehuuhieu
 */
public class MainController extends HttpServlet {


    private static final String LOGIN = "LoginController";
    private static final String ERROR = "error.jsp";
    private static final String CREATECATEGORY = "CreateCategoryController";
    private static final String UPDATECATEGORY = "UpdateCategoryController";
    private static final String SEACH_INDEX_USER = "SearchIndexUserController";
    private static final String UPDATE_CART = "UpdateCartController";
    private static final String APPLYCODE = "ApplyCodeDiscountController";
    private static final String CREATE_DISCOUNT_CODE = "CreateDiscountCodeController";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        try {
            String action = request.getParameter("action");
            log("action: " + action);
            if("Login".equals(action)) {
                url = LOGIN;
            } else if("SignUpCategory".equals(action)) {
                url = CREATECATEGORY;
            } else if("UpdateCategory".equals(action)) {
                url = UPDATECATEGORY;
            } else if("SearchIndexUser".equals(action)) {
                url = SEACH_INDEX_USER;
            } else if("UpdateCart".equals(action)) {
                url = UPDATE_CART;
            } else if("ApplyCodeDiscount".equals(action)) {
                url = APPLYCODE;
            } else if("CreateDiscountCode".equals(action)) {
                url = CREATE_DISCOUNT_CODE;
            }
        } catch (Exception e) {
            log("ERROR at MainController: " + e.getMessage());
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
