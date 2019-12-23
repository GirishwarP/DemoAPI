package org.girish.webservice.myWebService.messageModel;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private int ID;
	private String messageText;
	private Date created;
	private String author;
	
	public Message(){
		
	}
	
	public Message(int iD, String messageText, Date created, String author) {
		super();
		ID = iD;
		this.messageText = messageText;
		this.created = created;
		this.author = author;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
