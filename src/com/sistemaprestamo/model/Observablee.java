package com.sistemaprestamo.model;

public interface Observablee {

	void registrar(Observador obj);
	void unregister(Observador obj);
	void notificarObservador();
	
}
