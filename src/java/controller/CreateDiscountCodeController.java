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
import tblCode.CodeDAO;
import tblCode.CodeError;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "CreateDiscountCodeController", urlPatterns = {"/CreateDiscountCodeController"})
public class CreateDiscountCodeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "error.jsp";
        try {
            String code = request.getParameter("txtCode");
            String valueTemp = request.getParameter("txtValue");
            float value = -1;
            boolean valid = true;
            CodeError error = new CodeError();
            if(code.isEmpty()) {
                valid = false;
                error.setCodeError("Code can't be blank");
            }
            if (valueTemp.isEmpty() || !valueTemp.matches("\\b\\d+\\b")) {
                valid = false;
                error.setValueError("Value can't be blank or must be a number");
            } else {
                value = Float.parseFloat(valueTemp);
            }
            if (valid) {
                CodeDAO dao = new CodeDAO();
                dao.create(code, value);
                request.setAttribute("SUCCESS", "Create code successfully");
                url = "ListAllDiscountCodeController";
            } else {
                url = "createDiscountCode.jsp";
                request.setAttribute("ERROR", error);
            }
        } catch (Exception e) {
            log("ERROR at CreateDiscountCodeController: " + e.getMessage());
            if ("REFERENCES".contains(e.getMessage())) {
                CodeError error = new CodeError();
                error.setCodeError("Code name can't duplicate");
                request.setAttribute("ERROR", error);
                url = "createDiscountCode.jsp";
            }
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
