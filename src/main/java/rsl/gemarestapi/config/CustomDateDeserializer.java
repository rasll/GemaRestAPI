/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author solofoniaina
 */
public class CustomDateDeserializer <T extends Date> extends JsonDeserializer<T> {
    
    private static final List<DateFormat> knownPatterns = new ArrayList<DateFormat>();
    static{
        knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd"));
        knownPatterns.add(rsl.gemarestapi.util.WsUtil.getDateFormat());
    }

    @Override
    public T deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        String dateString = jp.getValueAsString();

        for(DateFormat pattern:knownPatterns){
            try {
                T date = (T) Date.class.newInstance();
                date.setTime(pattern.parse(dateString).getTime());
                return date;
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(CustomDateDeserializer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                //Logger.getLogger(CustomDateDeserializer.class.getName()).log(Level.SEVERE, null, ex);
                //continue loop
            }
        }
        Logger.getLogger(CustomDateDeserializer.class.getName()).log(Level.SEVERE, "No known Date format found for: \"" + dateString+"\"");
        return null;
    }
    
}
