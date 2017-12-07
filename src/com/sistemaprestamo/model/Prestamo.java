package com.sistemaprestamo.model;

import java.util.Calendar;
import java.util.Date;

public class Prestamo implements Modificable{

	
	private int id_prestamo;
	private String tipo_prestamo;
	private float monto_prestado;
	private Date fecha_inicio_prestamo;
	private Date fecha_final_prestamo;
	private long max_tiempo;   // tiempo limite para cada prestamo.............
	private float monto_max;  // monto maximo al que califica el cliente.......
	private Interes interest;
    private float cuota_mensual;
    private float total;

	
	
	
    
    
    
	
	public Prestamo() {
		
		this.id_prestamo = 0;
		this.tipo_prestamo = "";
		this.monto_prestado = 0.0f;
		setFecha_inicial();
		defaultMaxTime();
	}



	public Prestamo(String tipo_p) {
		
		this.id_prestamo = 0;
		this.tipo_prestamo = tipo_p;
		this.monto_prestado = 0.0f;
		setFecha_inicial();
		defaultMaxTime();
	}

	
	
	private void setTotalDeuda() {
		
		float monthRate = (interest.getValor() * monto_prestado);
		total = monto_prestado + monthRate;
	}
	
	public float getDeudaTotal() {
		
		setTotalDeuda();
		return total;
	}
	
	
	private void calcularCuotaMensual() {
		
	     int[] duracion = this.getDuracionPrestamo();
	     
	     int anos = duracion[0];
	     int mes = duracion[1];
	     mes +=(anos*12);    
	     float temp = monto_prestado/mes;
	     float monthlyRate = temp * interest.getValor();
	     this.cuota_mensual = temp+ monthlyRate;   
	     
	     System.out.println(mes);
	     
	}
	
	
	public float getCuotaMensual() {
		
		calcularCuotaMensual();
		return this.cuota_mensual;
	}
	
	
	public void setInteres(Interes interes) {
		
		this.interest = interes;
	}
	
	
	public Interes getInteres() {
		return this.interest; 
	}
	
	
	
	
    private void defaultMaxTime() {
    	
	if(tipo_prestamo.equalsIgnoreCase("Prestamos Educativos")) {
			
			this.max_tiempo = 157766400016L;
			
		}else if(tipo_prestamo.equalsIgnoreCase("Prestamos Hipotecarios")) {
			
			this.max_tiempo = 315532800015L;
			
		}else if(tipo_prestamo.equalsIgnoreCase("Prestamos Personales")) {
			
			this.max_tiempo = 63072000016L;
		}
    	
    }
	
	
	
	
	
	
	
	
	public void setMaxTiempo(final long maxTime) {
		this.max_tiempo = maxTime;	
	}
	
	
	
	public long getMaxTiempo() {
		return this.max_tiempo;
	}
	
	
	public int[] getDuracionPrestamo() {
	
		
		long difference  = this.fecha_final_prestamo.getTime() - this.fecha_inicio_prestamo.getTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(difference);
		
		int year = calendar.get(Calendar.YEAR) - 1970;
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		
		int[] resul = {year,month,day};
		 return resul;
	}
	
	
	
	
	
	
	/*
	public void calcularIntereses() {
		
		
		if(tipo_prestamo.equalsIgnoreCase("Prestamos Hipotecarios")) {
			
			this.interes_mensual = 0.12f;
			this.interes_anual = 0.30f;
			
		}else if(tipo_prestamo.equalsIgnoreCase("Prestamos Personales")) {
			
			this.interes_mensual = 0.25f;
			this.interes_anual = .015f;
			
		}else if(tipo_prestamo.equalsIgnoreCase("Prestamos educativos")) {
			
			this.interes_mensual = 0.4f;
			this.interes_anual = 0.26f;
		}
		
	}
	
	*/
	
	
	
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



	public float getMonto_prestamo() {
		return monto_prestado;
	}



	public boolean aprobarMonto(float monto) {
		
		boolean isDone = false;
		
		if(monto <= monto_max) {
		   monto_prestado = monto;
		   isDone = true;
	
		}else { isDone = false; }
		
		return isDone;
		
	}



	public Date getFecha_inicio_prestamo() {
		return fecha_inicio_prestamo;
	}



	private void setFecha_inicial() {
		
		fecha_inicio_prestamo = new Date();
	}



	public Date getFecha_final_prestamo() {
		return fecha_final_prestamo;
	}


	
	
	

	public void setFecha_final_prestamo(Date fin){
		
		long diferencia = fecha_inicio_prestamo.getTime() - fin.getTime();
		
		if(tipo_prestamo.equalsIgnoreCase("Prestamos Personales")) {
			
			if(diferencia <= this.max_tiempo){
				
				this.fecha_final_prestamo = fin;
				
			 }else { this.fecha_final_prestamo = null; }
			
		}else if(tipo_prestamo.equalsIgnoreCase("Prestamos educativos")) {
			
			if(diferencia <= this.max_tiempo) {
				
				this.fecha_final_prestamo = fin;
			}else {
				
				this.fecha_final_prestamo = null;
			}
			
		}else if(tipo_prestamo.equalsIgnoreCase("Prestamos Hipotecarios")) {
			
			if(diferencia <= this.max_tiempo) {
				
				this.fecha_final_prestamo = fin;
			}else {
				   this.fecha_final_prestamo = null;
			  }
		
           }
		
	}
	
	
	
	public float getMaxMontoApproved(float salario) {
		
		monto_max = getMaxMontoApproved(salario, this.tipo_prestamo);
		
		return monto_max;
	}
	
	
	
	public static float getMaxMontoApproved(float salary,String tipoP) {
		
		float monto = 0.0f;
	  
		if(salary < 10000f) {
			
			monto = 0.0f;
			
		}else {
			
			  if(tipoP.equalsIgnoreCase("Prestamos Personales")) {
			
			     monto = salary * (4/7f)*10f;
			
		        }else if(tipoP.equalsIgnoreCase("Prestamos educativos")) {
			
			         monto = salary * (6/8f) * 10f;
			
		         }else { monto = salary* (9/10f) *10f;
		       }
		  
		    }
		
		  return monto;
	}
	
	
	
	
	
	
	
	
	public String getPrestamoInterestRateInfo() {
		
	      float intRate = interest.getValor();
		  String tipo_Interes = interest.getTipo_interes();
		  String periodo = interest.getPeriodo();
		
		return tipo_Interes + ", " + intRate + ", "+periodo;
	}
	
	
	
	@Override
	public String toString() {
		return "Prestamo id= " + id_prestamo + "\ntipo_prestamo=" + tipo_prestamo + "\nmonto_prestamo="
				+ monto_prestado + "\nfecha_inicio_prestamo=" + fecha_inicio_prestamo + "\nfecha_final_prestamo="
				+ fecha_final_prestamo + "\n";
	}



	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
