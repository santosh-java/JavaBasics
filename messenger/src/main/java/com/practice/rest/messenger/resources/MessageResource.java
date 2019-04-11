package com.practice.rest.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("messages")
public class MessageResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessages() {
		return "Hello world!!!";
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessages(int id) {
		
		return "Hello world!!!";
	}
}