/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblBook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class BookDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<BookDTO> listAll() throws NamingException, SQLException {
        List<BookDTO> list = null;

        try {
            String sql = "select bookId, bookName, title, image, description, price, author, importDate, quantity, status, b.categoryId, categoryName\n"
                    + "from tblBook b\n"
                    + "inner join tblCategory c\n"
                    + "on b.categoryId = c.categoryId\n"
                    + "where status = 'active'";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            list = new ArrayList<>();
            rs = pst.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookName = rs.getString(2);
                String title = rs.getString(3);
                String image = rs.getString(4);
                String description = rs.getString(5);
                float price = rs.getFloat(6);
                String author = rs.getString(7);
                Date importDate = rs.getDate(8);
                int quantity = rs.getInt(9);
                String status = rs.getString(10);
                int categoryId = rs.getInt(11);
                String categoryName = rs.getString(12);
                list.add(new BookDTO(bookId, bookName, title, image, description, price, author, importDate, quantity, status, categoryId, categoryName));
            }

        } finally {
            closeConnection();
        }
        return list;
    }

    public void create(BookDTO dto) throws NamingException, SQLException {
        try {
            String sql = "insert tblBook values (?,?,?,?,?,?,?,?,?,?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dto.getBookName());
            pst.setString(2, dto.getTitle());
            pst.setString(3, dto.getImage());
            pst.setString(4, dto.getDescription());
            pst.setFloat(5, dto.getPrice());
            pst.setString(6, dto.getAuthor());
            pst.setDate(7, dto.getImportDate());
            pst.setInt(8, dto.getQuantity());
            pst.setString(9, dto.getStatus());
            pst.setInt(10, dto.getCategoryId());
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }

    public BookDTO findBookById(int bookId) throws NamingException, SQLException {
        BookDTO dto = null;

        try {
            String sql = "select bookId, bookName, title, image, description, price, author, importDate, quantity, status, b.categoryId, categoryName\n"
                    + "from tblBook b\n"
                    + "inner join tblCategory c\n"
                    + "on b.categoryId = c.categoryId\n"
                    + "where bookId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            rs = pst.executeQuery();
            while (rs.next()) {
                bookId = rs.getInt(1);
                String bookName = rs.getString(2);
                String title = rs.getString(3);
                String image = rs.getString(4);
                String description = rs.getString(5);
                float price = rs.getFloat(6);
                String author = rs.getString(7);
                Date importDate = rs.getDate(8);
                int quantity = rs.getInt(9);
                String status = rs.getString(10);
                int categoryId = rs.getInt(11);
                String categoryName = rs.getString(12);
                dto = new BookDTO(bookId, bookName, title, image, description, price, author, importDate, quantity, status, categoryId, categoryName);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public void delete(int bookId) throws NamingException, SQLException {
        try {
            String sql = "update tblBook set status = 'inactive' where bookId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }
    
    public void update(BookDTO dto) throws NamingException, SQLException {
        try {
            String sql = "update tblBook set bookName = ?, title = ?, image = ?, description = ?, price = ?, author = ?, importDate = ?, quantity = ?, status = ?, categoryId = ?\n"
                    + "where bookId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dto.getBookName());
            pst.setString(2, dto.getTitle());
            pst.setString(3, dto.getImage());
            pst.setString(4, dto.getDescription());
            pst.setFloat(5, dto.getPrice());
            pst.setString(6, dto.getAuthor());
            pst.setDate(7, dto.getImportDate());
            pst.setInt(8, dto.getQuantity());
            pst.setString(9, dto.getStatus());
            pst.setInt(10, dto.getCategoryId());
            pst.setInt(11, dto.getBookId());
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }
    
        public List<BookDTO> listBy(String bookName, float money1, float money2, String categoryName) throws NamingException, SQLException {
        List<BookDTO> list = null;

        try {
            String sql = "select bookId, bookName, title, image, description, price, author, importDate, quantity, status, b.categoryId, categoryName\n"
                    + "from tblBook b\n"
                    + "inner join tblCategory c\n"
                    + "on b.categoryId = c.categoryId\n"
                    + "where status = 'active'";
            if(!bookName.isEmpty()) {
                sql = sql.concat("and bookName like N'%" + bookName + "%'");
            }
            if(money1 != -1 && money2 != -1) {
                sql = sql.concat("and price between " + money1 + " and " + money2);
            }
            if(!categoryName.isEmpty()) {
                sql = sql.concat("and categoryName like N'%" + categoryName + "%'");
            }
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            list = new ArrayList<>();
            rs = pst.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                bookName = rs.getString(2);
                String title = rs.getString(3);
                String image = rs.getString(4);
                String description = rs.getString(5);
                float price = rs.getFloat(6);
                String author = rs.getString(7);
                Date importDate = rs.getDate(8);
                int quantity = rs.getInt(9);
                String status = rs.getString(10);
                int categoryId = rs.getInt(11);
                categoryName = rs.getString(12);
                list.add(new BookDTO(bookId, bookName, title, image, description, price, author, importDate, quantity, status, categoryId, categoryName));
            }

        } finally {
            closeConnection();
        }
        return list;
    }
        
        public int checkQuantity(int bookId) throws NamingException, SQLException {
            int quantity = -1;
            try {
                String sql = "select quantity\n"
                        + "from tblBook\n"
                        + "where bookId = ?";
                con = ConnectDB.makeConnnection();
                pst = con.prepareStatement(sql);
                pst.setInt(1, bookId);
                rs = pst.executeQuery();
                while(rs.next()) {
                    quantity = rs.getInt(1);
                }
            } finally {
                closeConnection();
            }
            return quantity;
        }
}
