/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblBook;

/**
 *
 * @author lehuuhieu
 */
public class BookError {
    
    private String bookNameError, titleError, imagesError, descriptionError, priceError, authorError, importDateError, quantityError, statusError;

    public BookError() {
    }

    public BookError(String bookNameError, String titleError, String imagesError, String descriptionError, String priceError, String authorError, String importDateError, String quantityError, String statusError) {
        this.bookNameError = bookNameError;
        this.titleError = titleError;
        this.imagesError = imagesError;
        this.descriptionError = descriptionError;
        this.priceError = priceError;
        this.authorError = authorError;
        this.importDateError = importDateError;
        this.quantityError = quantityError;
        this.statusError = statusError;
    }

    public String getBookNameError() {
        return bookNameError;
    }

    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }

    public String getTitleError() {
        return titleError;
    }

    public void setTitleError(String titleError) {
        this.titleError = titleError;
    }

    public String getImagesError() {
        return imagesError;
    }

    public void setImagesError(String imagesError) {
        this.imagesError = imagesError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getAuthorError() {
        return authorError;
    }

    public void setAuthorError(String authorError) {
        this.authorError = authorError;
    }

    public String getImportDateError() {
        return importDateError;
    }

    public void setImportDateError(String importDateError) {
        this.importDateError = importDateError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }
    
}
