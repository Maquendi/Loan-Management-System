package com.sistemaprestamo.model;

import java.util.ArrayList;

public class Modelo implements Observablee{

	private Persona person;
	private Empleado empleado;
	private JEFE jefe;
	private Cliente cliente;
	private Solicitud solicitud;
	private Prestamo prestamo;
	private Interes interes;
	private Caso caso;
	private ArrayList<Observador> observadores;
	
	
	
	public Modelo() {
		observadores = new ArrayList<>();
		
		this.person = new Persona();
		this.empleado = new Empleado();
		this.jefe = new JEFE();
		this.cliente = new Cliente();
		this.solicitud = new Solicitud();
		this.prestamo = new Prestamo();
		this.interes = new Interes();
		this.caso = new Caso();
	}

	
	
	public Modelo(Modelo model) {
		
		person = model.getPerson();
		empleado = model.getEmpleado();
		jefe = model.getJefe();
		cliente = model.getCliente();
		solicitud = model.getSolicitud();
		prestamo = model.getPrestamo();
		interes = model.getInteres();
		caso = model.getCaso();
	}
	
	
	
	
	public Persona getPerson() {
		return person;
	}

	public void setPerson(Persona person) {
		this.person = person;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
		
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
		
	}

	public Interes getInteres() {
		return interes;
	}

	public void setInteres(Interes interes) {
		this.interes = interes;
		
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
		
	}

	public JEFE getJefe() {
		return jefe;
	}

	public void setJefe(JEFE jefe) {
		this.jefe = jefe;
	
	}

	
	
	@Override
	public void registrar(Observador observer) {
		observadores.add(observer);
	}

	
	@Override
	public void unregister(Observador observer) {
		
		Integer observerIndex = observadores.indexOf(observer);
		
		System.out.println("Observador " + observerIndex + " Eliminado");
		observadores.remove(observer);
	}

	
	@Override
	public void notificarObservador() {
		
		for(Observador o : observadores) {
			o.actualizar(this);
		}
		
	}






  
}
