package com.sistemaprestamo.model;

import java.util.Date;

public class Empleo {

	private Date inicioEmpleo;
	private String nombreEmpresa;
	private String telefonoEmpresa;
	private double salario;
	
	
	
	
	public Empleo() {
		
	}
	
	
	
	
	public Empleo(Date inicioEmpleo, String nombreEmpresa, String telefonoEmpresa, Double salario) {
		super();
		this.inicioEmpleo = inicioEmpleo;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.salario = salario;
	}
	
	
	
	public Date getInicioEmpleo() {
		return inicioEmpleo;
	}
	public void setInicioEmpleo(Date inicioEmpleo) {
		this.inicioEmpleo = inicioEmpleo;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}
	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}




	@Override
	public String toString() {
		return "Empleo [inicioEmpleo=" + inicioEmpleo + ", nombreEmpresa=" + nombreEmpresa + ", telefonoEmpresa="
				+ telefonoEmpresa + ", salario=" + salario + "]";
	}
	
	
	
}
