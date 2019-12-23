package org.girish.webservice.myWebService.messageService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.girish.webservice.myWebService.messageData.Data;
import org.girish.webservice.myWebService.messageModel.Message;


public class MessageService {

	private Map<Integer,Message> messages = Data.getMessages();
		
	public MessageService(){
		messages.put(1, new Message(1, "message1", new Date(), "girish"));
		messages.put(2, new Message(2, "message2", new Date(), "bhushan"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(int id){
		return messages.get(id);
	}
	
	//Filtering the messages on the basis of year
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageList = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messageList.add(message);
			}
		}
		return messageList;
	}
	
	//adding Pagination to messages
	public List<Message> getAllMessagesPaginated(int start, int end){
		ArrayList<Message> messageList = new ArrayList<Message>(messages.values());	
		if((start+end) > messageList.size()) return new ArrayList<Message>();
		return messageList.subList(start, end);
	}
	
	public Message addMessage(Message msg){
		msg.setID(messages.size()+1);
		messages.put(msg.getID(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){
		if(msg.getID() <= 0){
			return null;
		}
		messages.put(msg.getID(), msg);
		return msg;
	}
	
	public Message removeMessage(int id){
		return messages.remove(id);
	}
}
