package com.sistemaprestamo.model;

import java.util.Date;

public class Prestamo{

	
	private int id_prestamo;
	private String tipo_prestamo;
	private int tipoPrestamo;
	private double monto_prestado;
	private String plazo;
	private Date fecha_inicio_prestamo;
	private Date fecha_final_prestamo;
	private Interes interest;
    private double cuota_mensual;
    private double total;
    private int id_Aprobacion;

	
		
	public Prestamo() {}


	
	public double getDeudaTotal() {
		return total;
	}
	
		
	public double getCuotaMensual() {
		
		return this.cuota_mensual;
	}
	
	public void setCuota_Mensual(double cuota) {
		cuota_mensual = cuota;
	}
	
	public void setInteres(Interes interes) {
		
		this.interest = interes;
	}
	
	
	public Interes getInteres() {
		return this.interest; 
	}
	
		
	public int getId_prestamo() {
		return id_prestamo;
	}



	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}



	public String getTipo_prestamo() {
		return tipo_prestamo;
	}



	public void setTipo_prestamo(String tipo_prestamo) {
		this.tipo_prestamo = tipo_prestamo;
	}


	public void setmonto_prestamo(double monto) {
	
		this.monto_prestado = monto;
	}

	public double getMonto_prestamo() {
		return monto_prestado;
	}


	public Date getFecha_inicio_prestamo() {
		return fecha_inicio_prestamo;
	}

    public void setFecha_inicio_prestamo(Date inicio) {
    	this.fecha_inicio_prestamo = inicio;
    }


	public Date getFecha_final_prestamo() {
		return fecha_final_prestamo;
	}

	
	@Override
	public String toString() {
		return "Prestamo id= " + id_prestamo + "\ntipo_prestamo=" + tipo_prestamo + "\nmonto_prestamo="
				+ monto_prestado + "\nfecha_inicio_prestamo=" + fecha_inicio_prestamo + "\nfecha_final_prestamo="
				+ fecha_final_prestamo + "\n";
	}

	
	public int getTipoPrestamo() {
		return tipoPrestamo;
	}



	public void setTipoPrestamo(int tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}



	public String getPlazo() {
		return plazo;
	}



	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}



	public int getId_Aprobacion() {
		return id_Aprobacion;
	}



	public void setId_Aprobacion(int id_Aprobacion) {
		this.id_Aprobacion = id_Aprobacion;
	}
	
	
}
