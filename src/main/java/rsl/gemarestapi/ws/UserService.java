/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.ws;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rsl.gemarestapi.model.BadRequestException;
import rsl.gemarestapi.model.JsonRequest;
import rsl.gemarestapi.model.JsonResponse;
import rsl.gemarestapi.util.WsUtil;
import rsl.gemarestapi.entity.User;
/**
 *
 * @author solofoniaina
 */

@Stateless
@Path("user")
public class UserService {
    @PersistenceContext 
    EntityManager entityManager;
    
    //Get all user
    @POST
    @Path("/get_all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResponse getAll(JsonRequest rq) throws BadRequestException{
        
        JsonResponse res = new JsonResponse();
        try {
            WsUtil.verifyRequest(rq);
        } catch (Exception e) {
            throw new BadRequestException(null, e);
        }
        
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u")
                .getResultList();
        res.getPayload().put("listUser", resultList);
        return res;
    }
}
