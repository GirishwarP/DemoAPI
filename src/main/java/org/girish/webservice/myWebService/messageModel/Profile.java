package org.girish.webservice.myWebService.messageModel;

import java.util.Date;

public class Profile {

	private int id;
	private String profileName;
	private String fName;
	private String lName;
	private Date created;
	
	public Profile(){
		
	}

	public Profile(int id, String profileName, String fName, String lName, Date created) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.fName = fName;
		this.lName = lName;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}	
}
