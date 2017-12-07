package com.sistemaprestamo.model;

public class User {

	private String userName;
	private String pass;
	private String priviledge;
	
	
	public User(String user,String pass,String priviledge) {
		this.userName = user;
		this.pass = pass;
		this.priviledge = priviledge;
	}
	
	
	
	
	
	public User() {
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPriviledge() {
		return priviledge;
	}
	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}
	
	
}
