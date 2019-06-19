package com.distributor.boundaries;

import com.distributor.controls.interfaces.IDistributorDtoManager;
import com.distributor.controls.interfaces.IDrinkDtoManager;
import com.distributor.dtos.DistributorDto;
import com.distributor.entities.Distributor;
import com.distributor.enums.Coin;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("distributor")
@Produces(MediaType.TEXT_PLAIN)
public class DistributorResource {

    @Inject
    IDistributorDtoManager distributorManager;

    @Inject
    IDrinkDtoManager drinkDtoManager;

    private static HashMap<String,Object> ent;

    public DistributorResource() {
        ent = new HashMap<>();
    }

    //    http://localhost:8080/DistributorBack_war/api/distributor
    @GET
    public String getWelcome(){
        return "welcome to distributor resource";
    }

    //génération d'un jeu d'essai (illimité pas de contrainte d'unicité dans le nom)
    //http://localhost:8080/DistributorBack_war/api/distributor/generateAppDistributorTest
    @GET
    @Path("/generateAppDistributorTest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateAppDistributorTest(){
        ent.put("Distributors",distributorManager.generateDistributorDtos());
        return Response.ok().entity(ent).build();
    }

    //http://localhost:8080/DistributorBack_war/api/distributor/getDistributor/Distributeur%200
    @GET
    @Path("/getDistributor/{distributorName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDistributor(@PathParam("distributorName") String name){
        ent.put("DistributorDto",distributorManager.getDistributorDtosByName(name));
        return Response.ok().entity(ent).build();
    }

    //http://localhost:8080/DistributorBack_war/api/distributor/getAllDistributorsDto
    @GET
    @Path("/getAllDistributorsDto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDistributorsDto(){
        ent.put("Distributors", distributorManager.getAllDistributorDtos());
        return Response.ok().entity(ent).build();
    }

    //simple query en jsonB
    //http://localhost:8080/DistributorBack_war/api/distributor/getJsonBDistributorDtoTest
    @GET
    @Path("/getJsonBDistributorDtoTest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonBDistributorDtoTest() {
        ent.put("Distributors",distributorManager.getJsonBDistributorDtoTest());
        return Response.ok().entity(ent).build();
    }

    //query avec jointure en jsonB
    //http://localhost:8080/DistributorBack_war/api/distributor/getJsonBJointureDtoTest
    @GET
    @Path("/getJsonBJointureDtoTest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonBJointureDtoTest() {
        ent.put("Distributors",distributorManager.getJsonBJointureDtoTest());
        return Response.ok().entity(ent).build();
    }

    //Tous les distributeurs dont les piéces de xx sont >= à xx et jointure lignes ou le nom de boisson xx a une quantité >= à xx
    //http://localhost:8080/DistributorBack_war/api/distributor/getDistributorDtoIfCoinIfDrink/UN_EUROS/99/Coca-Cola/20
    @GET
    @Path("/getDistributorDtoIfCoinIfDrink/{coinName}/{coinAmount}/{drinkName}/{drinkAmount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonBJointureDtoTest(
            @PathParam("coinName") String cName,
            @PathParam("coinAmount") int cAmount,
            @PathParam("drinkName") String dName,
            @PathParam("drinkAmount") int dAmount
            ) {
        ent.put("Distributors",distributorManager.getDistributorDtoIfCoinIfDrink(cName, cAmount, dName, dAmount));
        return Response.ok().entity(ent).build();
    }

    //http://localhost:8080/DistributorBack_war/api/distributor/getDrinkDtos
    @GET
    @Path("/getDrinkDtos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrinkDtos() {
        ent.put("Drinks",drinkDtoManager.getDrinkDtos());
        return Response.ok().entity(ent).build();
    }

    //a rajouter le json
    //http://localhost:8080/DistributorBack_war/api/distributor/saveDistributor
    @POST
    @Path("/saveDistributor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveDistributor(DistributorDto distributorDto){
        Distributor distributor = new Distributor(distributorDto.getName());
        distributor.setCoinJsonHashMap(distributorDto.getCoinJsonHashMap());


        ent.put("Drinks",distributorManager.saveDistributor(distributor).get(0));
        return Response.ok().entity(ent).build();
    }


}