package com.distributor.boundaries;

import com.distributor.fields.CoinJsonHashMapField;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.TreeSet;

@Path("field")
@Produces(MediaType.TEXT_PLAIN)
public class FieldResource {

    private static HashMap<String,Object> ent;

    public FieldResource() {
        ent = new HashMap();
    }

    //http://localhost:8080/DistributorBack_war/api/field
    @GET
    public String testDefaultResource(){
        return "welcome to field default resource";
    }

    //http://localhost:8080/DistributorBack_war/api/field/getCoinJsonHashMapField
    @GET
    @Path("/getCoinJsonHashMapField")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestMyConstat() {

        TreeSet<String> strings= new TreeSet<>();
        strings.add("01 - Montant");
        strings.add("02 - 1 centime");
        strings.add("03 - 2 centimes");
        strings.add("04 - 5 centimes");
        strings.add("05 - 10 centimes");
        strings.add("06 - 20 centimes");
        strings.add("07 - 50 centimes");
        strings.add("08 - 1 euro");
        strings.add("09 - 2 euros");

        CoinJsonHashMapField coinJsonHashMapField = new CoinJsonHashMapField(strings);
        ent.put("CoinJsonHashMapField", coinJsonHashMapField);

        return Response.ok().entity(ent).build();

    }


}
