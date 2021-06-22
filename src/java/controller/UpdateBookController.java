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
@WebServlet(name = "UpdateBookController", urlPatterns = {"/UpdateBookController"})
public class UpdateBookController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        String url = "error.jsp";
//        try {
//            String bookIdTemp = request.getParameter("txtBookId");
//            String bookName = request.getParameter("txtBookName");
//            String title = request.getParameter("txtTitle");
//            String description = request.getParameter("txtDescription");
//            String priceTemp = request.getParameter("txtPrice");
//            String author = request.getParameter("txtAuthor");
//            String categoryIdTemp = request.getParameter("category");
//            
//            int bookId = Integer.parseInt(bookIdTemp);
//            float price = Float.parseFloat(priceTemp);
//            int categoryId = Integer.parseInt(categoryIdTemp);
//            
//            
//            
//            BookDAO dao = new BookDAO();
//            BookDTO dto = new BookDTO(bookId, bookName, title, image, description, price, author, categoryId);
//            dao.update(dto);
//            request.setAttribute("SUCCESS", "Update successfully");
//            url = "ListAllAdminController";
//        } catch (Exception e) {
//            log("ERROR at UpdateBookController: " + e.getMessage());
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

        String url = "error.jsp";
        try {
            String bookIdTemp = request.getParameter("txtBookId");
            String bookName = request.getParameter("txtBookName");
            String title = request.getParameter("txtTitle");
            String description = request.getParameter("txtDescription");
            String priceTemp = request.getParameter("txtPrice");
            String author = request.getParameter("txtAuthor");
            String importDateTemp = request.getParameter("txtImportDate");
            String quantityTemp = request.getParameter("txtQuantity");
            String status = "active";

            String categoryIdTemp = request.getParameter("category");

            int bookId = Integer.parseInt(bookIdTemp);

            Date importDate = Date.valueOf(importDateTemp);

            BookError error = new BookError();
            boolean valid = true;

            Part part = request.getPart("file");
            String realPath = request.getServletContext().getRealPath("/images");
            log("realPath: " + realPath);
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            log("fileName: " + fileName);
            if (fileName.isEmpty()) {
                fileName = request.getParameter("txtFile");
            } else {
                for (String x : fileName.split(".")) {
                    if (!x.equals("jpg") || !x.equals("png")) {
//                        url = INVALID;
                    }
                }

                if (!fileName.isEmpty()) {
                    if (!Files.exists(Paths.get(realPath))) {
                        Files.createDirectories(Paths.get(realPath));
                    }
                    part.write(realPath + "/" + fileName);
                }
            }

            int categoryId = Integer.parseInt(categoryIdTemp);

            if (bookName.isEmpty()) {
                valid = false;
                error.setBookNameError("Book Name can't be blank");
            }
            if (title.isEmpty()) {
                valid = false;
                error.setTitleError("Title can't be blank");
            }
            if (fileName.isEmpty()) {
                valid = false;
                error.setImagesError("Image must select");
            }
            if (description.isEmpty()) {
                valid = false;
                error.setDescriptionError("Description can't be blank");
            }
            float price = -1;
            if (priceTemp.isEmpty() || !priceTemp.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                valid = false;
                error.setPriceError("Price can't be blank or must be a number");
            } else {
                price = Float.parseFloat(priceTemp);
            }
            if (author.isEmpty()) {
                valid = false;
                error.setAuthorError("Author can't be blank");
            }
            if (importDateTemp.isEmpty()) {
                valid = false;
                error.setImportDateError("Date must be select");
            } else {
                Date currentDate = Date.valueOf(LocalDate.now());
                if (importDate.after(currentDate)) {
                    valid = false;
                    error.setImportDateError("The date must be before today");
                }
            }
            int quantity = -1;
            if (quantityTemp.isEmpty() || !quantityTemp.matches("\\b\\d+\\b")) {
                valid = false;
                error.setQuantityError("Quantity can't be blank or must be a number");
            } else {
                quantity = Integer.parseInt(quantityTemp);
            }
            CategoryDAO categorydao = new CategoryDAO();
            List<CategoryDTO> list = categorydao.listCategory();
            request.setAttribute("CATEGORY", list);

            if (valid) {
                BookDAO dao = new BookDAO();
                BookDTO dto = new BookDTO(bookId, bookName, title, fileName, description, price, author, importDate, quantity, status, categoryId);
                dao.update(dto);
                request.setAttribute("SUCCESS", "Update successfully");
                url = "ListAllAdminController";
            } else {
                url = "update.jsp";
                request.setAttribute("ERROR", error);
            }
        } catch (Exception e) {
            log("ERROR at UpdateBookController: " + e.getMessage());
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
