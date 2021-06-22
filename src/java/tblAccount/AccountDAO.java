/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class AccountDAO {
    
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public void closeConnection() throws SQLException{
        if(rs != null) {
            rs.close();
        }
        if(pst != null) {
            pst.close();
        }
        if(con != null) {
            con.close();
        }
    }
    
    public AccountDTO checkRole(String username, String password) throws SQLException, NamingException{
        AccountDTO dto = null;
        try { 
            String sql = "select role, fullname\n"
                    + "from tblAccount\n"
                    + "where username = ? and password = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while(rs.next()) {
                String role = rs.getString(1);
                String fullname = rs.getString(2);
                dto = new AccountDTO(fullname, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        boolean check = false;
        try {
            String sql = "select role\n"
                    + "from tblAccount\n"
                    + "where username = ? and password = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while(rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
