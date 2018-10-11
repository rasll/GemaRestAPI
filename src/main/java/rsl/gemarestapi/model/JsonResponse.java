/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import rsl.gemarestapi.util.WsUtil;

/**
 *
 * @author solofoniaina
 */
public class JsonResponse {
    
    private Status status;
    private HashMap<String,Object> payload;
    private static final String APIVERSION=WsUtil.getApiVersion();

    //Constructors
    
    public JsonResponse() {
        this(new Status(200, "OK", ""));
    }
    
    public JsonResponse(Status status) {
        this.status = status;
    }
    
    public JsonResponse(javax.ws.rs.core.Response.Status status) {
        this.setStatus(status);
    }
    
    public JsonResponse(Status status, HashMap<String,Object> payload) {
        this.status = status;
        this.payload = payload;
    }

    //Getters - Setters

    @JsonProperty("api-version")
    public String getApiVersion() {
        return APIVERSION;
    }
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStatus(javax.ws.rs.core.Response.Status status){
        this.status = new Status(status);
    }
    public HashMap<String,Object> getPayload() {
        if(payload==null) payload=new HashMap<String,Object>();
        return payload;
    }

    public void setPayload(HashMap<String,Object> payload) {
        this.payload = payload;
    }
    
}
