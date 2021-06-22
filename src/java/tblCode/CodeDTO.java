/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblCode;

import java.io.Serializable;

/**
 *
 * @author lehuuhieu
 */
public class CodeDTO implements Serializable{
    
    private String code;
    private float value;

    public CodeDTO() {
    }

    public CodeDTO(String code, float value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    
    
}
