package com.sistemaprestamo.model;

public interface Observador {

	
	void actualizar();
	
	void actualizar(Persona p);
	
	void actualizar(Modificable obj);
	
	void actualizar(Modelo modelo);
	
	
}
