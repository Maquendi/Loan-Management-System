package com.sistemaprestamo.model;

import java.util.Date;

public class Cliente extends Persona {
	
	private boolean isWorking;
	private String tiempoLaborando;
	private Prestamo mi_prestamo;
	private double deuda;
	private double salario;
	

	public Cliente() {
		super();
		this.isWorking = true;
		this.tiempoLaborando = "";
		salario = 0.0f;
	}

	public Cliente(String name, String ced, char sex, String dir, Date nac, String tel,boolean working,String tl) {
		super(name, ced, sex, dir, nac, tel);
		this.isWorking = working;
		this.tiempoLaborando = tl;
		salario = 0.0f;	
	}
	
	
	
	
	
	public double getSalario() {
		return salario;
	}
	
	
	public void setSalario(double sal) {
		
		salario = sal;
	}
	
	
	
	public void darPrestamo(Prestamo prestamo) {
		this.mi_prestamo = prestamo;
		this.deuda = prestamo.getDeudaTotal();
	}
	
	
	
	public Prestamo getPrestamo(){
		return this.mi_prestamo;
	}
	

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	public String getTiempoLaborando() {
		return tiempoLaborando;
	}

	public void setTiempoLaborando(String tiempoLaborando) {
		this.tiempoLaborando = tiempoLaborando;
	}

	@Override
	public String toString() {
		return super.toString() + "is Working= " + isWorking + "\ntiempoLaborando= " + tiempoLaborando + "";
	}

	
	
	public void pagarCuota(double monto) {
		
		if(this.deuda > monto || this.deuda == monto) {
			this.deuda = this.deuda - monto;
		}
	
	  }
	
	
	public double getDeuda() {
		return deuda;
	}
	
	
}
