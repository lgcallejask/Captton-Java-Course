package com.Captton.clase5.ejercicio1;

public class ExcepcionAlquilado extends Exception{
	
	String miMensajeDeExcepcion;
		
	public ExcepcionAlquilado(String mensaje){
		this.miMensajeDeExcepcion = mensaje;
	}
		
	@Override
	public String getMessage() { 
		return this.miMensajeDeExcepcion;
	}

}
	