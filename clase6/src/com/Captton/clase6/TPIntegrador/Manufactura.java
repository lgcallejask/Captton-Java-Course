package com.Captton.clase6.TPIntegrador;

public class Manufactura extends Producto{

	int stock;
	float costoDeMateriaPrimaUnitario;
	
	Manufactura(int id, String nombre, float precioUnitario, int stock, float costoDeMateriaPima) {
		super(id, nombre, precioUnitario);
		this.stock=stock;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public float getCostoDeMateriaPrimaUnitario() {
		return costoDeMateriaPrimaUnitario;
	}

	public void setCostoDeMateriaPrimaUnitario(float costoDeMateriaPrima) {
		this.costoDeMateriaPrimaUnitario = costoDeMateriaPrima;
	}
	


	public String fabricar(int unaCantidad){
		stock+=unaCantidad;
		return "Se agrego una cantidad de "+unaCantidad+" al stock.";
	}
	
	public String vender(int unaCantidad, Cliente unCliente){
		try {
			Cliente.comprobarClienteHabilitado(unCliente);
			Manufactura.comprobarStockSuficiente(this.stock, unaCantidad);
			this.stock-=unaCantidad;
			return Producto.generarFacutra(this.precioUnitario, unaCantidad, unCliente);
		}
		catch (ExcepcionCliente e){
			return e.getMessage();
		}
		catch (ExcepcionCantidadStock e){
			return e.getMessage();
		}
	}
	
	static void comprobarStockSuficiente(int cantidadEnStock, int cantidadAVender) throws ExcepcionCantidadStock{
		if (cantidadEnStock<cantidadAVender) {
			throw new ExcepcionCantidadStock("No hay stock suficiente.");
		}
	}
}