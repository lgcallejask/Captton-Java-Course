package com.Captton.clase5.ejercicio1;

public class ExcepcionKilometraje extends Exception{
	
	String miMensajeDeExcepcion;
		
	public ExcepcionKilometraje(String mensaje){
		this.miMensajeDeExcepcion = mensaje;
	}
		
	@Override
	public String getMessage() { 
		return this.miMensajeDeExcepcion;
	}

}
	
