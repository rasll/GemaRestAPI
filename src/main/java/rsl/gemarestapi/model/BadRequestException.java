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
public class BadRequestException extends AbstractCustomException {
    
    public BadRequestException(String message,List<String>exceptions){
        super (Response.Status.BAD_REQUEST, message,exceptions);
    }
    
    public BadRequestException(String message,Exception exception){
        super (Response.Status.BAD_REQUEST, message,exception);
    }
}
