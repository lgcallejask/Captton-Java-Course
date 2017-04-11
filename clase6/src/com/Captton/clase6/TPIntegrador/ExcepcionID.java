package com.Captton.clase6.TPIntegrador;

public class ExcepcionID extends Exception {

	String miMensajeDeExcepcion;
	
	public ExcepcionID(String mensaje){
		this.miMensajeDeExcepcion = mensaje;
	}
	
	@Override
	public String getMessage(){ 
		return this.miMensajeDeExcepcion;
	}
}

