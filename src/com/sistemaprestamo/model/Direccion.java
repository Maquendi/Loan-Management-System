package com.sistemaprestamo.model;

public class Direccion {

	private int direccionID;
	private String calle;
	private String sector;
	private String ciudad;
	
	
	
	
	public Direccion() {
		
	}
	
	
	public Direccion(String calle,String sector,String ciudad) {
		this.calle = calle;
		this.sector = sector;
		this.ciudad = ciudad;
	}
	
	
	public int getDireccionID() {
		return direccionID;
	}
	public void setDireccionID(int direccionID) {
		this.direccionID = direccionID;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public String toString() {
		return "Direccion [direccionID=" + direccionID + ", calle=" + calle + ", sector=" + sector + ", ciudad="
				+ ciudad + "]";
	}
	
	
	
	
}
