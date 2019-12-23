package org.girish.webservice.myWebService.messageData;

import java.util.HashMap;
import java.util.Map;

import org.girish.webservice.myWebService.messageModel.Message;
import org.girish.webservice.myWebService.messageModel.Profile;

public class Data {

	private static Map<Integer,Message> messages = new HashMap<Integer,Message>();
	private static Map<String,Profile> profiles = new HashMap<String,Profile>();
	
	public static Map<Integer, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
