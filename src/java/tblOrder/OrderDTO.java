/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblOrder;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author lehuuhieu
 */
public class OrderDTO implements Serializable{
    
    private int orderId;
    private String username;
    private float total;
    private Date dateOrder;

    public OrderDTO() {
    }

    public OrderDTO(String username, float total, Date dateOrder) {
        this.username = username;
        this.total = total;
        this.dateOrder = dateOrder;
    }

    public OrderDTO(int orderId, String username, float total, Date dateOrder) {
        this.orderId = orderId;
        this.username = username;
        this.total = total;
        this.dateOrder = dateOrder;
    }
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }


    
}
