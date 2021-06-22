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
import tblCategory.CategoryDAO;
import tblCategory.CategoryError;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "UpdateCategoryController", urlPatterns = {"/UpdateCategoryController"})
public class UpdateCategoryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "error.jsp";
        try {
            String categoryIdTemp = request.getParameter("txtCategoryId");
            String categoryName = request.getParameter("txtCategoryName");
            int categoryId = Integer.parseInt(categoryIdTemp);

            boolean valid = true;
            CategoryError error = new CategoryError();
            if (categoryName.isEmpty() || categoryName.length() > 50) {
                error.setCategoryNameError("Category Name can't be blank or > 50 characters");
                valid = false;
            }

            if (valid) {
                CategoryDAO dao = new CategoryDAO();
                dao.update(categoryId, categoryName);
                request.setAttribute("SUCCESS", "Update Successfully");
                url = "ListAllCategoryController";
            } else {
                request.setAttribute("ERROR", error);
                url = "updateCategory.jsp";
            }
        } catch (Exception e) {
            log("ERROR at UpdateCategoryController: " + e.getMessage());
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
