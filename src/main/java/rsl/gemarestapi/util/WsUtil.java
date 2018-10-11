/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import rsl.gemarestapi.config.Constants;
import rsl.gemarestapi.config.JacksonConfig;
import rsl.gemarestapi.model.JsonRequest;

/**
 *
 * @author solofoniaina
 */
public class WsUtil {
    
    
    public static DateFormat getDateFormat() {
        
        return Constants.DATE_FORMAT;
    }

    public static String getApiVersion() {
        
        return Constants.REST_API_VERSION;
    }
    
    public static ObjectMapper getObjectMapper(){
        
        return new JacksonConfig().getContext(WsUtil.class);
    }
    
    public static String toSha256(String text){
        
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(WsUtil.class.getName()).log(Level.SEVERE, null, ex);
            //Should never happen
        }
        return null;
    }
    public static <E> E updateIgnoreNull(E oldEntity, E newEntity) {
        
        Field[] newEntityFields = newEntity.getClass().getDeclaredFields();
        Hashtable newHT = fieldsToHT(newEntityFields, newEntity);

        Class oldEntityClass = oldEntity.getClass();
        Field[] oldEntityFields = oldEntityClass.getDeclaredFields();

        for (Field field : oldEntityFields){
            if(field.getName().contains("serialVersionUID")) continue;
            field.setAccessible(true);
            Object o = newHT.get(field.getName());
            if (o != null){
                try {
                    Field f = oldEntityClass.getDeclaredField(field.getName());
                    f.setAccessible(true);
                    f.set(oldEntity, o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
        return oldEntity;
    }



    private static Hashtable<String, Object> fieldsToHT(Field[] fields, Object obj){
        
        Hashtable<String,Object> hashtable = new Hashtable<>();
        for (Field field: fields){
            field.setAccessible(true);
            try {
                Object retrievedObject = field.get(obj);
                if (retrievedObject != null){
                    hashtable.put(field.getName(), field.get(obj));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return hashtable;
    }
    
    public static void verifyRequest(JsonRequest request, String... fields) throws Exception{
        
        String msg="Incorrect request data";
        ArrayList list=new ArrayList();
        if(request==null) throw new Exception(msg);
        if(request.getPayload()==null) throw new Exception(msg+": No 'payload'");
        for(String field:fields){
            if(request.getPayload().get(field)==null) list.add(field);
        }
        if(!list.isEmpty())throw new Exception(msg+": Field(s) "+list.toString()+" required");
    }
    
    public static void verifyFieldsNotNull(Object obj, String... fieldNames) throws Exception{
        
        ArrayList<String> fieldsNotSet=new ArrayList<>();
        for(String fieldName:fieldNames){
            try {
                Field field = obj.getClass().getField(fieldName);
                if(field.get(obj)==null){
                    fieldsNotSet.add(fieldName);
                }
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(WsUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(WsUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(WsUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(WsUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!fieldsNotSet.isEmpty()) throw new Exception("Fields "+fieldsNotSet+" required");
    }
    
}
