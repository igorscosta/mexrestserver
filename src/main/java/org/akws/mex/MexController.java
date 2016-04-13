package org.akws.mex;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.*;

/**
 * Created by igorcosta on 12/04/16.
 */

@Path("/setexperiment")
public class MexController {
    @Path("/getauthorname")
    @GET
    @Produces("application/json")
    public JsonArray getAuthorName(){
        JsonArrayBuilder builder = Json.createArrayBuilder();
        builder.add(Json.createObjectBuilder().add("Athor", "Igu Costa"));
        return builder.build();
    }

    /*@Path("/setauthorname")
    @POST
    @Consumes("application/json")
    public JsonArray setAuthorName(){
        String authorName = json.
    }*/

}
