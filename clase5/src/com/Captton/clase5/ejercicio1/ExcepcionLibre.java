package com.Captton.clase5.ejercicio1;

public class ExcepcionLibre extends Exception{
	
	String miMensajeDeExcepcion;
		
	public ExcepcionLibre(String mensaje){
		this.miMensajeDeExcepcion = mensaje;
	}
		
	@Override
	public String getMessage() { 
		return this.miMensajeDeExcepcion;
	}

}
	