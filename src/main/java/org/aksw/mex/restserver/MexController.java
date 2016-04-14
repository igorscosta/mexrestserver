package org.aksw.mex.restserver;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Iterator;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.print.attribute.standard.Media;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.aksw.mex.log4mex.MyMEXVO;
import org.aksw.mex.log4mex.MEXSerializer;

/**
 * Created by igorcosta on 12/04/16.
 */

@Path("/setexperiment")
public class MexController {
    @Path("/getauthorname")
    @GET
    @Produces("application/json")
    public JsonArray getAuthorName() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        builder.add(Json.createObjectBuilder().add("Author", "Igu Costa"));
        return builder.build();
    }

    @Path("/setauthorname")
    @POST
    @Consumes("application/json")
    public String setAuthorName(String content) throws Exception {
        MyMEXVO mex = new MyMEXVO();

        JSONParser parser = new JSONParser();
        String stringToParse = content;
        Object obj = parser.parse(stringToParse);
        JSONObject jsonObject = (JSONObject) obj;
        String authorName = (String) jsonObject.get("Author");
        System.out.println("Nome do autor:" + authorName);

        mex.setAuthorName(authorName);
        MEXSerializer.getInstance().parse(mex);
        MEXSerializer.getInstance().saveToDisk("/Users/igorcosta/Downloads/experiment.ttl","",mex);
        //return Response.status(201);
        return "Author: " + authorName;

    }
}




