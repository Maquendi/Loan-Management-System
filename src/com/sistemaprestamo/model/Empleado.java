package com.sistemaprestamo.model;

public class Empleado extends Persona {
	

	private String cargo;
	
	private User user;
	
	
	public Empleado() {}
	
	
	
	public void setPosicion(String pos) {
		this.cargo = pos;
	}
	
	
	public String getPosicion() {
		return this.cargo;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	

}
