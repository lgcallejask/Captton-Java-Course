package com.Captton.clase3.ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;

public class Cliente {

	String nombre;
	String apellido;
	int dni;
	ArrayList<CuentaBancaria> cuentasBancarias;
	
	public Cliente(){};
	public Cliente(String nombre, String apellido, int dni){
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.cuentasBancarias = new ArrayList<CuentaBancaria>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public ArrayList<CuentaBancaria> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(getNombre()+" ");
		str.append(getApellido()+" ");
		str.append(getDni());
		return str.toString();
	}
	
	public String cuentas(){
		return CuentaBancaria.cuentas(this.cuentasBancarias);
	}
	
	public String bancosDeLosQueEsCliente(){
		HashSet<Banco> bancos = CuentaBancaria.bancos(this.cuentasBancarias);
		StringBuilder str = new StringBuilder();
		for (Banco banco : bancos){
			str.append(banco.toString()+"\n");
		}
		return str.toString();
	}
	
	public String tarjetasQueTiene(){
		ArrayList<TarjetaDebito> tarjetas = CuentaBancaria.tarjetas(this.cuentasBancarias);
		StringBuilder str = new StringBuilder();
		for (TarjetaDebito tarjeta : tarjetas){
			str.append(tarjeta.toString()+"\n");
		}
		return str.toString();
	}
	
	public void agregarCuenta(CuentaBancaria cuenta){
		this.cuentasBancarias.add(cuenta);
	}
	
	public void depositarEnCuenta(CuentaBancaria cuenta, float monto){
		cuenta.acreditarMonto(monto);
	}
	
	public float montoTotalDeCuentas(){
		float total=0;
		for (CuentaBancaria cuenta: this.cuentasBancarias){
			total+=cuenta.monto;
		}
		return total;
	}
	
}
