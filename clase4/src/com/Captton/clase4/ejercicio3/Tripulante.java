package com.Captton.clase4.ejercicio3;

public class Tripulante {

	int id;
	String nombre;
	String apellido;
	byte edad;
	float horasDeVuelo;
	Categoria categoria;
	float horasParaPremio;
	float horasAcumuladas;
	
	public void sumarHorasVuelo(float horas){
		this.horasDeVuelo+=horas;
		this.horasAcumuladas+=horas;
	}
	
	public void viajar(float horas){
		this.sumarHorasVuelo(horas);
		if (this.horasAcumuladas>this.horasParaPremio){
			do {
				this.entregarPremio();
			} while (horasAcumuladas>=horasParaPremio);
		}
	}

	private void entregarPremio() {
		this.horasAcumuladas-=this.horasParaPremio
		
	}
	
	
	
}
