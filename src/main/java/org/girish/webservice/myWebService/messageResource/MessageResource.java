package org.girish.webservice.myWebService.messageResource;

import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.girish.webservice.myWebService.messageModel.Message;
import org.girish.webservice.myWebService.messageService.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(@QueryParam("year") int year, 
										@QueryParam("start") int start,
										@QueryParam("end") int end){
		if(year > 0){
			return ms.getAllMessagesForYear(year);
		}
		if(start >= 0 && end >= 0){
			return ms.getAllMessagesPaginated(start, end);
		}
		return ms.getAllMessages();
	}
	
	@GET
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("msgId") int msgId){
		return ms.getMessage(msgId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message msg, @Context UriInfo uriInfo){
		Message newMessage = ms.addMessage(msg);
		String newId = String.valueOf(newMessage.getID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
	}
	
	@PUT
	@Path("/{msgId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("msgId") int msgId, Message msg){
		msg.setID(msgId);
		return ms.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message removeMessage(@PathParam("msgId") int msgId){
		return ms.removeMessage(msgId);		
	}
}
