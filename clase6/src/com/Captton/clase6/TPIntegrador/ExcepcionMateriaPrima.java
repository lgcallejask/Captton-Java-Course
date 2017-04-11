package com.Captton.clase6.TPIntegrador;

public class ExcepcionMateriaPrima extends Exception {

	String miMensajeDeExcepcion;
	
	public ExcepcionMateriaPrima(String mensaje){
		this.miMensajeDeExcepcion = mensaje;
	}
	
	@Override
	public String getMessage(){ 
		return this.miMensajeDeExcepcion;
	}
}