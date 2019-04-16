package com.practice.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.practice.rest.messenger.model.Message;
import com.practice.rest.messenger.service.MessageService;

@Path("messages")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessages(@DefaultValue("0") @QueryParam("year") int year,
			@DefaultValue("-1") @QueryParam("start") int start, @DefaultValue("-1") @QueryParam("size") int size) {
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if (start >= 0 && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}

	@GET
	@Path("{id}")
	public Message getMessage(@PathParam("id") long id) {
		return messageService.getMessage(id);
	}

	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}

	@PUT
	@Path("{id}")
	public Message updateMessage(@PathParam("id") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("{id}")
	public void deleteMessage(@PathParam("id") long id) {
		messageService.deleteMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentsResource getCommentsResource() {
		return new CommentsResource();
	}
}
