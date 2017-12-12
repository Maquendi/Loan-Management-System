package com.sistemaprestamo.model;

public class Cliente extends Persona {
	
	private Prestamo mi_prestamo;


	public Cliente() {
		super();
	}


	public Cliente(Prestamo p){
		super();
		this.mi_prestamo = p;
	}
	
	public Prestamo getPrestamo(){
		return this.mi_prestamo;
	}
	

   public void setPrestamo(Prestamo p) {
	   this.mi_prestamo = p;
   }
	
}
