package org.akws.mex;

/**
 * Created by igorcosta on 07/04/16.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/mexrestserver/{name}")
public class MexRestServer {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String setAuthorName(@PathParam("name") String name) {
        String author = name;

        String result = "@Produces(\"application/xml\") Output: \n\nAuthor: \n\n" + author;
        return "<mexrestserver>" + "<author>" + author + "</author>" + "<setAuthorName>" + result + "</>" + "</mexrestserver>";
    }
}
