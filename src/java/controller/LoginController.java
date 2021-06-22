/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import tblAccount.AccountDAO;
import tblAccount.AccountDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "error.jsp";
        try {
//            AccountError errorObj = new AccountError();
            boolean valid = true;

            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");

            if (username.length() == 0) {
                valid = false;
//                errorObj.setUsernameError("Username can't be blank");
            }
            if (password.length() == 0) {
                valid = false;
//                errorObj.setPasswordError("Password can't be blank");
            }

            //Khi người dùng check vào "I'm not a robot", một Ajax request sẽ tự động 
            //gửi tới dịch vụ Google reCAPTCHA và nhận được một mã số xác thực nó được 
            //lưu trữ trên một Hidden field (g-recaptcha-response) của form
//            String gRecaptchaRespone = request.getParameter("g-recaptcha-response");
//            System.out.println(gRecaptchaRespone);
//            boolean verify = VerifyRecaptcha.verify(gRecaptchaRespone);
//            if (!verify) {
//                errorObj.setRecaptchaError("Captcha invalid");
//                valid = false;
//            }
            if (valid) {

                AccountDAO dao = new AccountDAO();
                HttpSession session = request.getSession();
                boolean check = dao.checkLogin(username, password);

                if (check) {
                    AccountDTO dto = dao.checkRole(username, password);
                    if ("user".equals(dto.getRole())) {
                        session.setAttribute("USERNAME", username);
                        session.setAttribute("FULLNAME", dto.getFullname());
                        session.setAttribute("ROLE", dto.getRole());
                        url = "ListAllUserController";
                    } else if ("admin".equals(dto.getRole())) {
                        session.setAttribute("USERNAME", username);
                        session.setAttribute("FULLNAME", dto.getFullname());
                        session.setAttribute("ROLE", dto.getRole());
                        url = "ListAllAdminController";
                    } else {
                        url = "error.jsp";
                        request.setAttribute("ERROR", "Role is invalid");
                    }
                } else {
                    url = "error.jsp";
                    request.setAttribute("ERROR", "User name and password is invalid");
                }

            } else {
//                url = "login.jsp";
//                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
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
