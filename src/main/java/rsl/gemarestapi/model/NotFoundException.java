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
public class NotFoundException extends AbstractCustomException{
    
    public NotFoundException (String message,List<String>exceptions){
        super(Response.Status.NOT_FOUND,message,exceptions);
    }
    
    public NotFoundException (String message,Exception exception){
        super(Response.Status.NOT_FOUND,message,exception);
    }
}
