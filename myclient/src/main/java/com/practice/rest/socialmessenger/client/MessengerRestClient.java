package com.practice.rest.socialmessenger.client;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.practice.rest.socialmessenger.model.Message;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MessengerRestClient {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/socialmessenger/webapi/messages");
		ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if(clientResponse.getStatus() == 200) {
			String res = clientResponse.getEntity(String.class);
			System.out.println("Response as string" + res);
			Gson g = new Gson();
			 List<Message> fromJson = Arrays.asList(g.fromJson(res, Message[].class));

			 for(Message m: fromJson) {
				 System.out.println(m);
			 }
			 
		}
	}

}
