/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import tblBook.BookDAO;
import tblBook.BookDTO;
import tblBook.BookError;
import tblCategory.CategoryDAO;
import tblCategory.CategoryDTO;

/**
 *
 * @author lehuuhieu
 */
@MultipartConfig
@WebServlet(name = "CreateBookController", urlPatterns = {"/CreateBookController"})
public class CreateBookController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ListAllAdminController";
    private static final String INVALID = "createBook.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        String url = ERROR;
//        try {
//            String image = "";
//            
//            String bookName = request.getParameter("txtBookName");
//            String title = request.getParameter("txtTitle");
//            String description = request.getParameter("txtDescription");
//            String tempPrice = request.getParameter("txtPrice");
//            String author = request.getParameter("txtAuthor");
//            String categoryIdTemp = request.getParameter("category");
//            log("categoryId: " + categoryIdTemp);
//            
//            int categoryId = Integer.parseInt(categoryIdTemp);
//            
//            float price = Float.parseFloat(tempPrice);
//            
//            
//            BookDAO dao = new BookDAO();
//            BookDTO dto = new BookDTO(bookName, title, image, description, price, author, categoryId);
//            dao.create(dto);
//            url = SUCCESS;
//        } catch (Exception e) {
//            log("ERROR at CreateController: " + e.getMessage());
//        } finally {
//            request.getRequestDispatcher(url).forward(request, response);
//        }
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
        String url = ERROR;
        try {

            String bookName = request.getParameter("txtBookName");
            String title = request.getParameter("txtTitle");
            String description = request.getParameter("txtDescription");
            String tempPrice = request.getParameter("txtPrice");
            String author = request.getParameter("txtAuthor");
            String quantityTemp = request.getParameter("txtQuantity");
            String categoryIdTemp = request.getParameter("category");

            Date importDate = Date.valueOf(LocalDate.now());
            String status = "active";

            int categoryId = Integer.parseInt(categoryIdTemp);

            BookError error = new BookError();
            boolean valid = true;

            Part part = request.getPart("file");
            String realPath = request.getServletContext().getRealPath("/images");
            log("realPath: " + realPath);
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            log("fileName: " + fileName);
            if (!fileName.isEmpty()) {
                for (String x : fileName.split(".")) {
                    if (!x.equals("jpg") || !x.equals("png")) {
                        valid = false;
                        error.setImagesError("Image must format jpg or png");
                    }
                }

                if (!fileName.isEmpty()) {
                    if (!Files.exists(Paths.get(realPath))) {
                        Files.createDirectories(Paths.get(realPath));
                    }
                    part.write(realPath + "/" + fileName);
                }
            }

            if (bookName.isEmpty() || bookName.length() > 50) {
                valid = false;
                error.setBookNameError("Book Name can't be blank or > 50 character");
            }
            if (title.isEmpty() || title.length() > 50) {
                valid = false;
                error.setTitleError("Title can't be blank or > 50 character");
            }
            if (fileName.isEmpty()) {
                valid = false;
                error.setImagesError("Image must select");
            }
            if (description.isEmpty() || description.length() > 255) {
                valid = false;
                error.setDescriptionError("Description can't be blank or > 255 character");
            }

            float price = -1;
            if (tempPrice.isEmpty() || !tempPrice.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                valid = false;
                error.setPriceError("Price can't be blank or must be a number");
            } else {
                if (!tempPrice.isEmpty()) {
                    price = Float.parseFloat(tempPrice);
                }
            }
            if (author.isEmpty() || author.length() > 50) {
                valid = false;
                error.setAuthorError("Author can't be blank or > 50 character");
            }

            int quantity = -1;
            if (quantityTemp.isEmpty() || !quantityTemp.matches("\\b\\d+\\b")) {
                valid = false;
                error.setQuantityError("Quantity can't be blank or must be a number");
            } else {
                if (!quantityTemp.isEmpty()) {
                    quantity = Integer.parseInt(quantityTemp);
                }
            }

            if (valid) {
                BookDAO dao = new BookDAO();
                BookDTO dto = new BookDTO(bookName, title, fileName, description, price, author, importDate, quantity, status, categoryId);
                dao.create(dto);
                url = SUCCESS;
                request.setAttribute("SUCCESS", "Create Book successfully");
            } else {
                CategoryDAO dao = new CategoryDAO();
                List<CategoryDTO> list = dao.listCategory();
                request.setAttribute("CATEGORY", list);
                url = INVALID;
                request.setAttribute("ERROR", error);
            }
        } catch (Exception e) {
            log("ERROR at CreateController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
