package com.Captton.clase3.ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;

public class Banco {

	String nombre;
	ArrayList<CuentaBancaria> cuentasBancarias;

	public Banco(String nombre) {
		this.nombre = nombre;
		this.cuentasBancarias = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	String toStirng(){
		return this.nombre;
	}
	
	public String clientes(){
		HashSet<Cliente> clientes =  CuentaBancaria.clientes(this.cuentasBancarias);
		StringBuilder str = new StringBuilder();
		for (Cliente cliente : clientes){
			str.append(cliente.toString()+"\n");
		}
		return str.toString();
	}
	
	public String cuentas(){
		return CuentaBancaria.cuentas(this.cuentasBancarias);
	}
	
	public String tarjetasEmitidas(){
		ArrayList<TarjetaDebito> tarjetas = CuentaBancaria.tarjetas(this.cuentasBancarias);
		StringBuilder str = new StringBuilder();
		for (TarjetaDebito tarjeta : tarjetas){
			str.append(tarjeta.toString()+"\n");
		}
		return str.toString();
	}
	
	public void darAltaCliente(Cliente cliente){
		CuentaBancaria cuenta = new CuentaBancaria((int)(Math.random()*100000), 0, this, cliente);
		TarjetaDebito tarjeta = new TarjetaDebito((int)(Math.random()*1000000000), cuenta);
		cuenta.setTarjetaDebito(tarjeta); //ver esto
		cliente.agregarCuenta(cuenta); 
		this.agregarCuenta(cuenta);
	}
	
	public void darBajaCliente(Cliente cliente){
		
	}
	
	public void agregarCuenta(CuentaBancaria cuenta){
		this.cuentasBancarias.add(cuenta);
	}
	
	public String toString(){
		return this.nombre;
	}
	
}
