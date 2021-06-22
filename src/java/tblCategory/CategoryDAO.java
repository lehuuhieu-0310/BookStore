/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import tblBook.BookDTO;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class CategoryDAO {

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


    public List<CategoryDTO> listCategory() throws Exception, NamingException {
        List<CategoryDTO> list = null;
        try {
            String sql = "select categoryId, categoryName\n"
                    + "from tblCategory\n";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            list = new ArrayList<>();
            rs = pst.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt(1);
                String categoryName = rs.getString(2);
                list.add(new CategoryDTO(categoryId, categoryName));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public void create(String categoryName) throws Exception, NamingException {
        try {
            String sql = "insert tblCategory values (?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, categoryName);
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }
    
    public CategoryDTO findById(int categoryId) throws Exception, NamingException {
        CategoryDTO dto = null;
        try {
            String sql = "select categoryId, categoryName\n"
                    + "from tblCategory\n"
                    + "where categoryId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, categoryId);
            rs = pst.executeQuery();
            while(rs.next()) {
                categoryId = rs.getInt(1);
                String categoryName = rs.getString(2);
                dto = new CategoryDTO(categoryId, categoryName);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public void update(int categoryId, String categoryName) throws Exception, NamingException {
        try {
            String sql = "update tblCategory set categoryName = ? where categoryId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, categoryName);
            pst.setInt(2, categoryId);
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }
    
    public void delete(int categoryId) throws NamingException, SQLException {
        try {
            String sql = "delete from tblCategory where categoryId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, categoryId);
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }
}
