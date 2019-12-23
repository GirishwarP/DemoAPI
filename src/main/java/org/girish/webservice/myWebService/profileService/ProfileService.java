package org.girish.webservice.myWebService.profileService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.girish.webservice.myWebService.messageData.Data;
import org.girish.webservice.myWebService.messageModel.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = Data.getProfiles();
	
	public ProfileService(){
		profiles.put("User", new Profile(1, "User", "girish", "patil", new Date()));
		profiles.put("Admin", new Profile(2, "Admin", "admin", "user", new Date()));
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateprofile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
