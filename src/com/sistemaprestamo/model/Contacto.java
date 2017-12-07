package com.sistemaprestamo.model;

public class Contacto {

	private int contactoID;
	private String email;
	private String telefono;
	
	
	
	
	public Contacto() {}
	
	
	public Contacto(String email, String tel) {
		this.email = email;
		this.telefono = tel;
	}
	
	
	
	
	public int getContactoID() {
		return contactoID;
	}
	public void setContactoID(int contactoID) {
		this.contactoID = contactoID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "Contacto [contactoID=" + contactoID + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
	
	
}
