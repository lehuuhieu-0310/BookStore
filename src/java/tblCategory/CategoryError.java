/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblCategory;

/**
 *
 * @author lehuuhieu
 */
public class CategoryError {
    private String categoryNameError;

    public CategoryError() {
    }

    public CategoryError(String categoryNameError) {
        this.categoryNameError = categoryNameError;
    }

    public String getCategoryNameError() {
        return categoryNameError;
    }

    public void setCategoryNameError(String categoryNameError) {
        this.categoryNameError = categoryNameError;
    }
    
    
}
