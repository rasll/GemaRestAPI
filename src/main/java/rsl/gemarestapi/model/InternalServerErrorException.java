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
public class InternalServerErrorException extends AbstractCustomException{
    
    public InternalServerErrorException(String message,List<String>exceptions){
        super(Response.Status.INTERNAL_SERVER_ERROR,message,exceptions);
    }
    
    public InternalServerErrorException(String message,Exception exception){
        super(Response.Status.INTERNAL_SERVER_ERROR,message,exception);
    }
}
