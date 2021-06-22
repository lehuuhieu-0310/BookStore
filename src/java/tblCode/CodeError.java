/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblCode;

/**
 *
 * @author lehuuhieu
 */
public class CodeError {

    private String codeError, valueError;

    public CodeError() {
    }

    public CodeError(String codeError, String valueError) {
        this.codeError = codeError;
        this.valueError = valueError;
    }

    public String getCodeError() {
        return codeError;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }

    public String getValueError() {
        return valueError;
    }

    public void setValueError(String valueError) {
        this.valueError = valueError;
    }

}
