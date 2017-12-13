package com.sistemaprestamo.model;

import java.util.Date;

public class Payment {

	
	private int id_payments;
	private int id_cliente;
	private Date fecha_pago;
	private double valor;
	private double amortizado;
	private double pendiente;
	
	
	
	
	
	
	
	
	public int getId_payments() {
		return id_payments;
	}
	public void setId_payments(int id_payments) {
		this.id_payments = id_payments;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getAmortizado() {
		return amortizado;
	}
	public void setAmortizado(double amortizado) {
		this.amortizado = amortizado;
	}
	public double getPendiente() {
		return pendiente;
	}
	public void setPendiente(double pendiente) {
		this.pendiente = pendiente;
	}
	
	
	
	
}
