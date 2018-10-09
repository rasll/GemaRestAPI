/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.model;

import javax.ws.rs.core.Response;

/**
 *
 * @author solofoniaina
 */
public class Status {
    
    private int code;
    private String title, message;

    public Status(int code, String title, String message) {
        this.code = code;
        this.title = title;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Status (Response.Status status){
        this.code=status.getStatusCode();
        this.title=status.toString();
        this.message=status.getReasonPhrase();
    }
    
}
