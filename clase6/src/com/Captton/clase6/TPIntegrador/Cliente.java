package com.Captton.clase6.TPIntegrador;

public class Cliente {
	
	int id;
	String nombre;
	String apellido;
	float deuda;
	boolean discriminarIVA;
	
	public Cliente(int id, String nombre, String apellido, float deuda, boolean discriminarIVA) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.deuda = deuda;
		this.discriminarIVA = discriminarIVA;
	}

	public boolean estaHabilitado(){
		return this.deuda<1000;
	}
	
	public void pagar(float unaCantidad){
		deuda-=unaCantidad;
	}

	static void comprobarClienteHabilitado(Cliente unCliente) throws ExcepcionCliente{
		if (!unCliente.estaHabilitado()) {
			throw new ExcepcionCliente("El cliente no esta habilitado.");
		}
	}
}
