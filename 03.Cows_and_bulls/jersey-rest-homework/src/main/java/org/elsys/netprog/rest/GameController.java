package org.elsys.netprog.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.resource.Singleton;


@Path("/game")
//@Singleton
public class GameController {
	
	private List<BaseGame> allGames = new ArrayList<BaseGame>();
	
	
	@POST
	@Path("/startGame")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response startGame() throws URISyntaxException{
		BaseGame newGame = new BaseGame();
		allGames.add(newGame);		
		return Response.ok(newGame.getUniqueID()).status(Status.CREATED).build();
	}
	
	@PUT
	@Path("/guess/{id}/{guess}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response guess(@PathParam("id") String gameId, @PathParam("guess") String guess) throws Exception{
		
     
        if(guess.length() > 4 || !uniqueString(guess)) {
    		return Response.status(400).build();
        }
    
		for(BaseGame game : allGames) {
			if(game.getUniqueID().equals(gameId)) {
				
			}
		}
		return Response.status(404).build();
	}
	
	@GET
	@Path("/games")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getGames() {
			return Response.ok(new ArrayList<BaseGame>(allGames)).build();

	}
	
	public boolean uniqueString (String guess) {
		
		Set<Character> set = new HashSet<Character>();
		char[] characters = guess.toCharArray();
		 
		for (Character c : characters) {
			 if (!set.add(c) || Character.isDigit(c)) {
				 return false;
			 } 
		 }
		return true;
	}
}
