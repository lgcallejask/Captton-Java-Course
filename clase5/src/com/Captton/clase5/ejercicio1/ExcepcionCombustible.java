package com.Captton.clase5.ejercicio1;

public class ExcepcionCombustible extends Exception{
		
	String miMensajeDeExcepcion;
		
	public ExcepcionCombustible(String mensaje){
		this.miMensajeDeExcepcion = mensaje;
	}
		
	@Override
	public String getMessage() { 
		return this.miMensajeDeExcepcion;
	}

}
	
