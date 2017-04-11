package com.Captton.clase6.TPIntegrador;

public class Servicio extends Producto {

	Servicio(int id, String nombre, float precioUnitario) {
		super(id, nombre, precioUnitario);
	}

	public String vender(int unaCantidad, Cliente unCliente){
		try {
			Cliente.comprobarClienteHabilitado(unCliente);
			return Producto.generarFacutra(this.precioUnitario, unaCantidad, unCliente);
		}
		catch (ExcepcionCliente e){
			return e.getMessage();
		}
	}
	
}
