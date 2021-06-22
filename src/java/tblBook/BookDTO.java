/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblBook;

import java.io.Serializable;
import java.sql.Date;
import tblCategory.CategoryDTO;

/**
 *
 * @author lehuuhieu
 */
public class BookDTO extends CategoryDTO implements Serializable {

    private int bookId;
    private String bookName, title, image, description;
    private float price;
    private String author;
    private Date importDate;
    private int quantity;
    private String status;

    public BookDTO() {
    }

    public BookDTO(int bookId, String bookName, String title, String image, String description, float price, String author, Date importDate, int quantity, String status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        this.author = author;
        this.importDate = importDate;
        this.quantity = quantity;
        this.status = status;
    }

    public BookDTO(String bookName, String title, String image, String description, float price, String author, Date importDate, int quantity, String status, int categoryId) {
        super(categoryId);
        this.bookName = bookName;
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        this.author = author;
        this.importDate = importDate;
        this.quantity = quantity;
        this.status = status;
    }

    public BookDTO(int bookId, String bookName, String title, String image, String description, float price, String author, Date importDate, int quantity, String status, int categoryId, String categoryName) {
        super(categoryId, categoryName);
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        this.author = author;
        this.importDate = importDate;
        this.quantity = quantity;
        this.status = status;
    }

    public BookDTO(int bookId, String bookName, String title, String image, String description, float price, String author, Date importDate, int quantity, String status, int categoryId) {
        super(categoryId);
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        this.author = author;
        this.importDate = importDate;
        this.quantity = quantity;
        this.status = status;
    }

    public BookDTO(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "bookId=" + bookId + ", bookName=" + bookName + ", title=" + title + ", image=" + image + ", description=" + description + ", price=" + price + ", author=" + author + ", importDate=" + importDate + ", quantity=" + quantity + ", status=" + status + '}';
    }


}
