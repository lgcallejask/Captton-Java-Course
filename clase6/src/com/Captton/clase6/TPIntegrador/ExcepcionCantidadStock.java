package com.Captton.clase6.TPIntegrador;

public class ExcepcionCantidadStock extends Exception {

	String miMensajeDeExcepcion;
	
	public ExcepcionCantidadStock(String mensaje){
		this.miMensajeDeExcepcion = mensaje;
	}
	
	@Override
	public String getMessage(){ 
		return this.miMensajeDeExcepcion;
	}
}
