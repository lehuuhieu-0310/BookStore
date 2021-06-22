/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblBook;

import java.util.HashMap;

/**
 *
 * @author lehuuhieu
 */
public class CartObj {
    private String username;
    private HashMap<String, BookDTO> cart;

    public CartObj() {
    }

    public CartObj(String username) {
        this.username = username;
        this.cart = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<String, BookDTO> getCart() {
        return cart;
    }

    public void addToCart(BookDTO dto) throws Exception {
        if(this.cart.containsKey(String.valueOf(dto.getBookId()))) {
            int quantity = this.cart.get(String.valueOf(dto.getBookId())).getQuantity() + 1;
            dto.setQuantity(quantity);
        }
        this.cart.put(String.valueOf(dto.getBookId()), dto);
    }
    
    public float getTotal() {
        float result = 0;
        for (BookDTO dto : this.cart.values()) {
            result += dto.getPrice() * dto.getQuantity();
        }
        return result;
    }
    
    public void remove(int id) throws Exception {
        if(this.cart.containsKey(String.valueOf(id))){
            this.cart.remove(String.valueOf(id));
        }
    }
    
    public void update(int id, int newQuantity) throws Exception {
        if(this.cart.containsKey(String.valueOf(id))) {
            this.cart.get(String.valueOf(id)).setQuantity(newQuantity);
        }
    }
}
