/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblOrder;

import java.sql.Connection;
import java.sql.Date;
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
public class OrderDAO {
    
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
    
    public Integer addOrder(String username, float total, Date dateOrder) throws NamingException, SQLException{
        int orderId = -1;
        try {
            String sql = "insert tblOrder values (?,?,?)\n"
                    + "select IDENT_CURRENT('tblOrder')";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setFloat(2, total);
            pst.setDate(3, dateOrder);
            pst.executeUpdate();
            
            sql = "select IDENT_CURRENT('tblOrder')";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                orderId = rs.getInt(1);
            }
        } finally {
            closeConnection();
        }
        return orderId;
    }
    
    public List<OrderDTO> findById(String username) throws NamingException, SQLException {
        List<OrderDTO> list = null;
        try {
            String sql = "select orderId, username, total, dateOrder\n"
                    + "from tblOrder\n"
                    + "where username = ?\n"
                    + "order by orderId desc";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            list = new ArrayList<>();
            rs = pst.executeQuery();
            while(rs.next()) {
                int orderId = rs.getInt(1);
                username = rs.getString(2);
                float total = rs.getFloat(3);
                Date dateOrder = rs.getDate(4);
                list.add(new OrderDTO(orderId, username, total, dateOrder));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
