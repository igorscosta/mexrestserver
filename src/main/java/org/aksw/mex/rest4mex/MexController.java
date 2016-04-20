package org.aksw.mex.rest4mex;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;

import org.aksw.mex.log4mex.MyMEXVO;
import org.aksw.mex.log4mex.MEXSerializer;

import org.aksw.mex.framework.annotations.InterfaceVersion;
import org.aksw.mex.framework.annotations.Start;
import org.aksw.mex.framework.annotations.algo.Algorithm;
import org.aksw.mex.framework.annotations.core.*;
import org.aksw.mex.framework.annotations.perf.Measure;
import org.aksw.mex.log4mex.algo.AlgorithmVO;
import org.aksw.mex.log4mex.core.HardwareConfigurationVO;
import org.aksw.mex.log4mex.core.SamplingMethodVO;
import org.aksw.mex.util.MEXEnum;

import java.util.Date;

/**
 * Created by igorcosta on 12/04/16.
 */

@Path("/experiment")
public class MexController {

    private  MyMEXVO mex = new MyMEXVO();

    @Path("/setauthorname")
    @POST
    @Consumes("application/json")
    public String setAuthorName(String content) throws Exception {

        JSONParser parser = new JSONParser();
        String stringToParse = content;
        Object obj = parser.parse(stringToParse);
        JSONObject jsonObject = (JSONObject) obj;
        String authorName = (String) jsonObject.get("author");
        System.out.println("Nome do autor:" + authorName);

        mex.setAuthorName(authorName);
        MEXSerializer.getInstance().parse(mex);
        MEXSerializer.getInstance().saveToDisk("/Users/igorcosta/Downloads/experiment.ttl","",mex);
        //return Response.status(201);
        return "Author: " + authorName;

    }

    @Path("/setexperimentinfo")
    @POST
    @Consumes("application/json")
    public String setExperomentInfo(String content) throws Exception {

        JSONParser parser = new JSONParser();
        String stringToParse = content;
        Object obj = parser.parse(stringToParse);
        JSONObject jsonObject = (JSONObject) obj;

        String experimentId = (String) jsonObject.get("id");
        String experimentTitle = (String) jsonObject.get("title");
        String experimentDescription = (String) jsonObject.get("description");
        String authorEmail= (String) jsonObject.get("email");
        String authorName = (String) jsonObject.get("author");
        Date experimentDate = (Date) jsonObject.get("date");
        String context = (String) jsonObject.get("context");

        System.out.println("experiment's id:" + experimentId);
        System.out.println("experiment's title:" + experimentTitle);
        System.out.println("experiment's descriptio :" + experimentDescription);
        System.out.println("authors's e-mail:" + authorEmail);
        System.out.println("author's name:" + authorName);
        System.out.println("experiment's date" + experimentDate);
        System.out.println("context:" + context);

        mex.setExperimentId(experimentId);
        mex.setExperimentTitle(experimentTitle);
        mex.setExperimentDescription(experimentDescription);
        mex.setAuthorEmail(authorEmail);
        mex.setAuthorName(authorName);
        mex.setExperimentDate(experimentDate);
        mex.setContext(content);


        MEXSerializer.getInstance().parse(mex);
        MEXSerializer.getInstance().saveToDisk("/Users/igorcosta/Downloads/experiment.ttl","",mex);
        //return Response.status(201);
        return "id: " + experimentId;

    }
}




