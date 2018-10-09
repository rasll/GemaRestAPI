/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.model;

import java.util.HashMap;

/**
 *
 * @author solofoniaina
 */
public class JsonRequest {
    
    HashMap<String,Object> payload;

    public HashMap<String,Object> getPayload() {
        return payload;
    }

    public void setPayload(HashMap<String,Object> payload) {
        this.payload = payload;
    }
}
