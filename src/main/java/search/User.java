package main.java.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;

	public User() {};
	
	public User (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
}
