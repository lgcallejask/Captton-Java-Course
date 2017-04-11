package com.Captton.clase6.TPIntegrador;

abstract public class Producto {
	
	int id;
	String nombre;
	float precioUnitario; //El precio de lista es sin IVA.
	
	Producto(int id, String nombre, float precioUnitario){
		this.id=id;
		this.nombre=nombre;
		this.precioUnitario=precioUnitario;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	
	abstract String vender(int unaCantidad, Cliente unCliente);
	
	String fabricar(int unaCantidad){
		return null;
	}	

	public float getCostoDeMateriaPrimaUnitario() {
		return 0;
	}
	
	public static String generarFacutra(float precioUnitario, int unaCantidad, Cliente unCliente) {
		StringBuilder str = new StringBuilder();
		float totalSinIVA = precioUnitario*unaCantidad;
		str.append("FACTURA:"+"\n");
		if (unCliente.discriminarIVA) {
			str.append("Precio total de lista: "+totalSinIVA+"\n");
			str.append("IVA: "+totalSinIVA*0.21+"\n");			
		}
		str.append("Total a pagar: "+totalSinIVA*1.21+"\n");
		return str.toString();
	}
	
}
