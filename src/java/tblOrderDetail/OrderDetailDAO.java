/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblOrderDetail;

import java.sql.Connection;
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
public class OrderDetailDAO {

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
    
    public void add(int orderId, int bookId, int quantity, float price) throws NamingException, SQLException {
        try {
            String sql = "insert tblOrderDetail values (?,?,?,?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            pst.setInt(2, bookId);
            pst.setInt(3, quantity);
            pst.setFloat(4, price);
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }
    
    public List<OrderDetailDTO> findById(int orderId) throws NamingException, SQLException {
        List<OrderDetailDTO> list = null;
        try {
            String sql = "select orderId, o.bookId, bookName, o.quantity, o.price\n"
                    + "from tblOrderDetail o\n"
                    + "inner join tblBook b\n"
                    + "on o.bookId = b.bookId\n"
                    + "where orderId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            list = new ArrayList<>();
            rs = pst.executeQuery();
            while (rs.next()) {
                orderId = rs.getInt(1);
                int bookId = rs.getInt(2);
                String bookName = rs.getString(3);
                int quantity = rs.getInt(4);
                float price = rs.getFloat(5);
                list.add(new OrderDetailDTO(orderId, bookId, bookName, quantity, price));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
 