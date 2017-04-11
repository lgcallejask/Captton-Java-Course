package com.Captton.clase6.TPIntegrador;

public class ExcepcionCliente extends Exception {

	String miMensajeDeExcepcion;
	
	public ExcepcionCliente(String mensaje){
		this.miMensajeDeExcepcion = mensaje;
	}
	
	@Override
	public String getMessage(){ 
		return this.miMensajeDeExcepcion;
	}
}
