package com.sistemaprestamo.model;

public class Referencia {

	private String name;
	private String apellido;
	private String telef;
	private String parentesco;
	
	
	
	
	
	
	
	public Referencia() {
		
	}
		
	public Referencia(String name,String apellido,String telef,String parentesco) {
		this.name = name;
		this.apellido = apellido;
		this.telef = telef;
		this.parentesco = parentesco;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelef() {
		return telef;
	}
	public void setTelef(String telef) {
		this.telef = telef;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	@Override
	public String toString() {
		return "Referencia [name=" + name + ", apellido=" + apellido + ", telef=" + telef + ", parentesco=" + parentesco
				+ "]";
	}
	
	
	
}
