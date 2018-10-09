/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author solofoniaina
 */
public abstract class AbstractCustomException extends Exception implements Serializable{
    private Status status;
    private HashMap<String,Object> payload=new HashMap<>();
    
    
    public AbstractCustomException(Response.Status status, String message, List<String> exceptions) {
        setStatus(new Status(status.getStatusCode(), status.name(), status.getReasonPhrase()));
        if(message!=null) setMessage(message);
        if(exceptions!=null) setExceptions(exceptions);
    }
    public AbstractCustomException(Response.Status status, String message, Exception exception) {
        this(status,message, (List)null);
        if(message==null) setMessage(exception.getMessage());
        while(exception!=null){
            addException(exception);
            exception=(Exception) exception.getCause();
        }
    }
    public AbstractCustomException(String message, Exception exception) {
        this(Response.Status.INTERNAL_SERVER_ERROR, message, exception);
    }
    
    public final Status getStatus() {
        return status;
    }

    public final void setStatus(Status status) {
        this.status = status;
    }

    public final HashMap<String, Object> getPayload() {
        return payload;
    }

    public final void setPayload(HashMap<String, Object> payload) {
        this.payload = payload;
    }
    
    public final void setExceptions(List<String> exeptions) {
        getPayload().put("exceptions",exeptions);
    }
    
    public final void addException(Exception exception) {
        if(getPayload().get("exceptions")==null) getPayload().put("exceptions", new ArrayList<String>());
        ((List)getPayload().get("exceptions")).add(exception.getMessage());
    }
    
    public final void setMessage(String message){
        getStatus().setMessage(message);  
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @JsonIgnore
    public synchronized Throwable getCause() {
        return super.getCause(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @JsonIgnore
    public String getLocalizedMessage() {
        return super.getLocalizedMessage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @JsonIgnore
    public String getMessage() {
        return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
     
}
