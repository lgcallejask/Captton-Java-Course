package com.Captton.clase3.ejercicio3;

public class TarjetaDebito {
	
	int id;
	CuentaBancaria cuenta;	
	
	public TarjetaDebito(int id, CuentaBancaria cuenta) {
		super();
		this.id = id;
		this.cuenta = cuenta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CuentaBancaria getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}
	
	public void debitar(float monto){
		this.cuenta.debitarMonto(monto);
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(id);
		str.append(cuenta.getCbu());
		return str.toString();
		
	}
	
}
