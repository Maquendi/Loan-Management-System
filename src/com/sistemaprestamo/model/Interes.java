package com.sistemaprestamo.model;

public class Interes {

	
		
		private String tipo_interes;
		private float valor;
		private String periodo;
		
		public Interes(String tipo,String per,float valor) {
			this.tipo_interes = tipo;
			this.periodo = per;
			this.valor = valor;	
		}
		
		public Interes() {}
		
		
		
		public String getPeriodo() {
			return periodo;
		}

		
		public void setPeriodo(String per) {
			periodo = per;
		}
		
		public String getTipo_interes() {
			return tipo_interes;
		}

		public void setTipo_interes(String tipo_interes) {
			this.tipo_interes = tipo_interes;
		}

		public float getValor() {
			return valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}

		@Override
		public String toString() {
			return "Interes [tipo_interes=" + tipo_interes + ", valor=" + valor + ", periodo=" + periodo + "]";
		}
		
		
		
		
}
