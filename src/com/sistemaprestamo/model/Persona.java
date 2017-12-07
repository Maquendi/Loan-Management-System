package com.sistemaprestamo.model;

import java.util.*;

public class Persona {

	private int persona_ID;
	private String nombre_Persona;
	private String apellido;
	private String cedula;
	private char sexo;
	private Date fecha_nac;
	private String nacionalidad;
	private String categoria;
	private Empleo empleo;
	private Direccion direccion;
	private Referencia ref;
	private Contacto contacto;
	
	
	
	
	

	// Default
	// Constructor-------------------------------------------------------------------------------------------------

	public Persona() {
		
		this.direccion = new Direccion();
		this.empleo = new Empleo();
		this.ref = new Referencia();
		this.contacto = new Contacto();
		
	}

	
	
	
	public Persona(String name, String ced, char sex, String dir, Date nac, String tel) {

		this.nombre_Persona = name;
		this.cedula = ced;
		this.sexo = sex;
		this.fecha_nac = nac;
	}

	
	
	
	
	
	

	public Direccion getDireccion() {
		
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	

	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;

	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;

	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;

	}


	public void setID(int id) {
		this.persona_ID = id;

	}

	public int getID() {
		return this.persona_ID;
	}

	public String getNombre_Persona() {
		return nombre_Persona;
	}

	public void setNombre_Persona(String nombre_Persona) {
		this.nombre_Persona = nombre_Persona;

	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;

	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;

	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;

	}


	public Referencia getRef() {
		return ref;
	}

	public void setRef(Referencia ref) {
		this.ref = ref;
	}


	public Empleo getEmpleo() {
		return empleo;
	}

	public void setEmpleo(Empleo empleo) {
		this.empleo = empleo;
	}




	@Override
	public String toString() {
		return "Persona [persona_ID=" + persona_ID + ", nombre_Persona=" + nombre_Persona + ", apellido=" + apellido
				+ ", cedula=" + cedula + ", sexo=" + sexo + ", fecha_nac=" + fecha_nac + ", nacionalidad="
				+ nacionalidad + ", categoria=" + categoria + ", empleo=" + empleo + ", direccion=" + direccion
				+ ", ref=" + ref + ", contacto=" + contacto + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + persona_ID;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (persona_ID != other.persona_ID)
			return false;
		return true;
	}
	
	
	
	
	
	

}
