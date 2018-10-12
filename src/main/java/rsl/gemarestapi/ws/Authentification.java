/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.ws;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javafx.scene.media.Media;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rsl.gemarestapi.entity.User;
import rsl.gemarestapi.model.BadRequestException;
import rsl.gemarestapi.model.JsonRequest;
import rsl.gemarestapi.model.JsonResponse;
import rsl.gemarestapi.util.JwtUtil;
import rsl.gemarestapi.util.WsUtil;

/**
 *
 * @author solofoniaina
 */
@Stateless
@Path("signin")
public class Authentification {
    @PersistenceContext
    EntityManager mEntityManager;
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResponse doLogin (JsonRequest request) throws BadRequestException{
        
        JsonResponse response = new JsonResponse();
        User user = null;
        
        //Verification de l'objet request
        try {
            WsUtil.verifyRequest(request, "user","password");
        } catch (Exception ex) {
            throw new BadRequestException(null, ex);
        }
        //Si request correct
        HashMap<String,Object> payload=request.getPayload();
        String login=(String)payload.get("user");
        String password=(String)payload.get("password");
        
        //Get user from DB
        Query query = mEntityManager.createQuery("FROM User WHERE user =:user AND password =:password")
                .setParameter("login", login)
                .setParameter("password", WsUtil.toSha256(password));
        try{
            user = (User) query.getSingleResult();
        }catch(Exception e){
            throw new BadRequestException("Login/password incorrect.", e);
        }
        //If user fetched
        //create token
        Map tokenPayload=new Hashtable<>();
        tokenPayload.put("user-id", user.getIduser());
        String token=JwtUtil.generateToken("Token of user "+user.getUser(), tokenPayload);
        response.getPayload().put("token", token);
        
        //Return user info
        response.getPayload().put("user-info", user);
        
        return response;
    }
}
