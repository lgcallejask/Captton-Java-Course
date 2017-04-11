package com.Captton.clase6.TPIntegrador;

public class Proveedor {

	int id;
	String nombre;
	MateriaPrima materiaPrima;
		
	public Proveedor(int id, String nombre, MateriaPrima materiaPrima) {
		this.id = id;
		this.nombre = nombre;
		this.materiaPrima = materiaPrima;
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
	
	public float vender(float unaCantidad, Empresa unaEmpresa){
		unaEmpresa.materiaPrima+=unaCantidad;
		return materiaPrima.precioUnitario*unaCantidad;
	}
		
}
