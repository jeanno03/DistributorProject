package com.distributor.boundaries;

import com.distributor.controls.interfaces.IAuthManager;
import com.distributor.models.Credential;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("auth")
public class AuthResource {

    @Inject
    IAuthManager authManager;

    private static HashMap<String,Object> ent;

    public AuthResource() {
        ent = new HashMap();
    }

    //    http://localhost:8080/DistributorBack_war/api/auth/testConnection
    //{"login":"Jean01","password":"12345678"}
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/testConnection")
    public Response testConnection(Credential credential){
        String token = authManager.getConnectReturnToken(credential);
        ent.put("token",token);
        if(token!=null){
            return Response.ok().entity(ent).build();
        }else{
            String str = "{\"error message\":\""+ " Unautorized !" +"\"}";
            return Response.status(401).entity(str).build();
        }
    }

    //http://localhost:8080/DistributorBack_war/api/auth/testConnection/Jean01/12345678
    @GET
    @Path("/testConnection/{login}/{password}")
    public String testConnection(@PathParam("login") String login, @PathParam("password") String password){
        Credential credential = new Credential(login, password);
        String token = authManager.getConnectReturnToken(credential);
        return token;
    }


}
