/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblCode;

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
public class CodeDAO {

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

    public boolean checkCode(String code) throws NamingException, SQLException {
        boolean valid = false;
        try {
            String sql = "select codeId\n"
                    + "from tblCode\n"
                    + "where code = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, code);
            rs = pst.executeQuery();
            while(rs.next()) {
                valid = true;
            }
        } finally {
            closeConnection();
        }
        return valid;
    }
    
    public float getValue(String code) throws NamingException, SQLException {
        float value = -1;
        try {
            String sql = "select value\n"
                    + "from tblCode\n"
                    + "where code = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, code);
            rs = pst.executeQuery();
            while(rs.next()) {
                value = rs.getFloat(1);
            }
        } finally {
            closeConnection();
        }
        return value;
    }
    
    public void create(String code, float value) throws NamingException, SQLException {
        try {
            String sql = "insert tblCode values(?,?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, code);
            pst.setFloat(2, value);
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }
    
    public List<CodeDTO> listAll() throws NamingException, SQLException {
        List<CodeDTO> list = null;
        try {
            String sql = "select code, value\n"
                    + "from tblCode";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            list = new ArrayList<>();
            rs = pst.executeQuery();
            while(rs.next()) {
                String code = rs.getString(1);
                float value = rs.getFloat(2);
                list.add(new CodeDTO(code, value));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
