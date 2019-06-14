package com.distributor.boundaries;

import com.distributor.constants.MyConstant;
import com.distributor.enums.Coin;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

@Path("enum")
@Produces(MediaType.TEXT_PLAIN)
public class EnumResource {

    private static HashMap<String,Object> ent;

    public EnumResource() {
        ent = new HashMap();
    }

    //http://localhost:8080/DistributorBack_war/api/enum
    @GET
    public String testDefaultResource(){
        return "welcome to enum default resource";
    }

    //http://localhost:8080/DistributorBack_war/api/enum/getCoins
    @GET
    @Path("/getCoins")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestMyConstat() {
        List<Coin> coins = MyConstant.COINS;
        ent.put("Coin",coins);
        return Response.ok().entity(ent).build();
    }

}
