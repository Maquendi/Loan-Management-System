package com.sistemaprestamo.model;


import java.util.Date;

import com.sistemaprestamo.model.Cliente;

public class Caso {

	
	private String caseNumber;
	private String caseReason;
	private Date fechaCaso;
    private Cliente cliente;
    private String status;
	
	
    
    public Caso() {};
    
	public Caso(Cliente cli,Date fecha,String numCaso,String razonCaso,String status) {
		
		this.cliente = cli;
		this.fechaCaso = fecha;
		this.caseNumber = numCaso;
		this.caseReason = razonCaso;
		this.status = status;
		
	}

	
public void setStatus(String status) {
		this.status = status;
	}

 public String getCaseStatus() {
	return status;
  }
	

	public String getCaseNumber() {
		return caseNumber;
	}


	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}


	public String getCaseReason() {
		return caseReason;
	}


	public void setCaseReason(String caseReason) {
		this.caseReason = caseReason;
	}


	public Date getFechaCaso() {
		return fechaCaso;
	}


	public void setFechaCaso(Date fechaCaso) {
		this.fechaCaso = fechaCaso;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return caseNumber;
	}
	
	
    
}
