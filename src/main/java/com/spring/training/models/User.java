package com.spring.training.models;

public class User {

	private String user_id;
	private String first_name;
	private String last_name;
	
	 public User(String id, String fname, String lname) {
		user_id = id;
		first_name = fname;
		last_name = lname;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
}
