package com.sistemaprestamo.model;

import java.util.Date;

public class Solicitud implements Modificable{

	private int num_solicitud;
	private Date fecha_solicitud;
	private double monto_solicitado;
	private double monto_Aprobado;
	private int plazo_en_meses;
	private int id_solicitante;
	private String tipo_prestamo;
	private int tipoPrestamos;
	private String estatus;
    private String razonDeclinacion;
    private int ID_Aprobacion;
	

	@Override
	public String toString() {
		return "Solicitud [num_solicitud=" + num_solicitud + ", fecha_solicitud=" + fecha_solicitud
				+ ", monto_solicitado=" + monto_solicitado + ", plazo_en_meses=" + plazo_en_meses + ", id_solicitante="
				+ id_solicitante + ", tipo_prestamo=" + tipo_prestamo + "]";
	}

	
	
	public String getTipo_prestamo() {
		return tipo_prestamo;
	}

	public void setTipo_prestamo(String tipo_prestamo) {
		this.tipo_prestamo = tipo_prestamo;
	}

	public Solicitud() {}
	
	public Solicitud(double monto_solicitado,int plazo) {
		this.monto_solicitado = monto_solicitado;
		this.plazo_en_meses = plazo;
	}
	
	
	public int getNum_solicitud() {
		return num_solicitud;
	}
	public void setNum_solicitud(int num_solicitud) {
		this.num_solicitud = num_solicitud;
	}
	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}
	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
	public double getMonto_solicitado() {
		return monto_solicitado;
	}
	public void setMonto_solicitado(double monto_solicitado) {
		this.monto_solicitado = monto_solicitado;
	}
	public int getPlazo_en_meses() {
		return plazo_en_meses;
	}
	public void setPlazo_en_meses(int plazo_en_meses) {
		this.plazo_en_meses = plazo_en_meses;
	}
	public int getId_solicitante() {
		return id_solicitante;
	}
	public void setId_solicitante(int id_solicitante) {
		this.id_solicitante = id_solicitante;
	}



	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}



	public int getTipoPrestamos() {
		return tipoPrestamos;
	}



	public void setTipoPrestamos(int tipoPrestamos) {
		this.tipoPrestamos = tipoPrestamos;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_solicitante;
		result = prime * result + num_solicitud;
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
		Solicitud other = (Solicitud) obj;
		if (id_solicitante != other.id_solicitante)
			return false;
		if (num_solicitud != other.num_solicitud)
			return false;
		return true;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public String getRazonDeclinacion() {
		return razonDeclinacion;
	}



	public void setRazonDeclinacion(String razonDeclinacion) {
		this.razonDeclinacion = razonDeclinacion;
	}



	public double getMonto_Aprobado() {
		return monto_Aprobado;
	}



	public void setMonto_Aprobado(double monto_Aprobado) {
		this.monto_Aprobado = monto_Aprobado;
	}



	public int getID_Aprobacion() {
		return ID_Aprobacion;
	}



	public void setID_Aprobacion(int id_estado) {
		this.ID_Aprobacion = id_estado;
	}
	
	
	
	
}
