package org.elsys.netprog.rest;

import java.net.URISyntaxException;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.spi.resource.Singleton;


@Path("/game")
//@Singleton
public class GameController {
	
	@GET
	@Path("/zdrasti")
	@Produces(MediaType.TEXT_PLAIN)
    public Response hello() {

        String output = "Hello World!";

        return Response.status(200).entity(output).build();
    }
	
	@POST
	@Path("/startGame")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response startGame() throws URISyntaxException{
		String uniqueID = UUID.randomUUID().toString();
		System.out.print("MInah be pich");
		System.out.print(uniqueID);
		return Response.ok(uniqueID).status(201).build();
	}
	
	@PUT
	@Path("/guess/{id}/{guess}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response guess(@PathParam("id") String gameId, @PathParam("guess") String guess) throws Exception{
		//TODO: Add your code here
		return Response.status(404).build();
	}
	
	@GET
	@Path("/games")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getGames() {
		//TODO: Add your code here
		return Response.status(404).build();
	}
}
