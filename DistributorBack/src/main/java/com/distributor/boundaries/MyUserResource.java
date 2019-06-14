package com.distributor.boundaries;

import com.distributor.controls.interfaces.IMyUserDtoManager;
import com.distributor.dtos.MyUserDto;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

@Path("user")
@Produces(MediaType.TEXT_PLAIN)
public class MyUserResource {

    @Inject
    IMyUserDtoManager myUserManager;

    private static HashMap<String,Object> ent;

    public MyUserResource() {
        ent = new HashMap();
    }

    //http://localhost:8080/DistributorBack_war/api/user/generateMyUsers
    //persist List<MyUser>
    @GET
    @Path("/generateMyUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateMyUsers() {
      List<MyUserDto> myUserDtos = myUserManager.generateMyUsers();
        if(myUserDtos==null){
            String str = "{\"error\":\""+ " Done already !" +"\"}";
            return Response.status(500).entity(str).build();
        }
        ent.put("myUserDtos",myUserDtos);
        return Response.ok().entity(ent).build();
    }

    //http://localhost:8080/DistributorBack_war/api/user/getMyUserDtoByName/Jean01
    //get MyUser from database native query
    @GET
    @Path("/getMyUserDtoByName/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMyUserDtoByName(@PathParam("userName") String name) {
        ent.put("myUserDto",myUserManager.getMyUserDtoByName(name).get(0));
        return Response.ok().entity(ent).build();
    }

    //http://localhost:8080/DistributorBack_war/api/user/getAllMyUserDtos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllMyUserDtos")
    public Response getAllMyUsers(){
        ent.put("MyUserDtos",myUserManager.getAllMyUserDtos());
        return Response.ok().entity(ent).build();
    }
}
