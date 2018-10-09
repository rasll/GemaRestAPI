/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.model;

import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author solofoniaina
 */
public class CustomException extends AbstractCustomException {

    public CustomException(Response.Status status, String message, List<String> exceptions) {
        super(status,message,exceptions);
    }
    
    public CustomException(Response.Status status, String message, Exception exception) {
        super(status, message, exception);
    }  
}
