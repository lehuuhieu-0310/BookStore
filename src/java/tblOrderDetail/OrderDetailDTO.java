/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblOrderDetail;

import java.io.Serializable;
import tblBook.BookDTO;

/**
 *
 * @author lehuuhieu
 */
public class OrderDetailDTO extends BookDTO implements Serializable{
    
    private int orderId, bookId, quantity;
    private float price;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int bookId, int quantity, float price) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetailDTO(int orderId, int bookId, String bookName, int quantity, float price) {
        super(bookName);
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
