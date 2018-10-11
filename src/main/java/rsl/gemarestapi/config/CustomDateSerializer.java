/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author solofoniaina
 */
public class CustomDateSerializer <T extends Date> extends JsonSerializer<T>{
    
    private static final DateFormat DF = Constants.DATE_FORMAT;

    @Override
    public void serialize(T t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
        jg.writeString(DF.format((Date)t));
    }
    
}
