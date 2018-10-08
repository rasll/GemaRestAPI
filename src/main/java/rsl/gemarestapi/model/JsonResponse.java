/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.model;

import java.util.HashMap;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author solofoniaina
 */
public class JsonResponse {
    
    private Status status;
    private HashMap<String,Object> payload;

    //Constructors
    public JsonResponse(Status status) {
        this.status = status;
    }

    public JsonResponse(Status status, HashMap<String,Object> payload) {
        this.status = status;
        this.payload = payload;
    }

    //Getters - Setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public HashMap<String,Object> getPayload() {
        if(payload==null) payload=new HashMap<>();
        return payload;
    }

    public void setPayload(HashMap<String,Object> payload) {
        this.payload = payload;
    }
    
}
