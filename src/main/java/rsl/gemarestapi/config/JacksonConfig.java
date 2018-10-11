/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.Date;
import javax.ws.rs.ext.ContextResolver;
import rsl.gemarestapi.util.WsUtil;

/**
 *
 * @author solofoniaina
 */
public class JacksonConfig implements ContextResolver<ObjectMapper> {
    
    private final ObjectMapper objectMapper;

    public JacksonConfig()
    {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        objectMapper.setDateFormat(WsUtil.getDateFormat());  
        SimpleModule dateDeserializerModule = new SimpleModule();
        dateDeserializerModule.addDeserializer(Date.class, new CustomDateDeserializer());
        objectMapper.registerModule(dateDeserializerModule);
        
    }
    
    @Override
    public ObjectMapper getContext(Class<?> arg0)
    {
        return objectMapper;
    }
    
    
}
