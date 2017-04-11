package com.Captton.clase3.ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;

public class CuentaBancaria {

	int cbu;
	float monto;
	Banco banco;
	Cliente cliente;
	TarjetaDebito tarjeta;
	
	public CuentaBancaria(){}
	public CuentaBancaria(int cbu, float monto, Banco banco, Cliente cliente) {
		this.cbu = cbu;
		this.monto = monto;
		this.banco = banco;
		this.cliente = cliente;
	}

	public long getCbu() {
		return cbu;
	}
	public void setCbu(int cbu) {
		this.cbu = cbu;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public TarjetaDebito getTarjeta(){
		return tarjeta;
	}
	public void setTarjetaDebito(TarjetaDebito tarjeta){
		this.tarjeta = tarjeta;
	}
	
	
	void acreditarMonto(float monto){
		this.monto+=monto;
	}
	
	void debitarMonto(float monto){
		this.monto-=monto;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(cbu+" ");
		str.append(monto+" ");
		str.append(banco.toString()+" ");
		str.append(cliente.toString()+" ");
		str.append(tarjeta.toString()+"\n");
		return str.toString();
	}
	
	static String cuentas( ArrayList<CuentaBancaria> cuentasBancarias){
		StringBuilder str = new StringBuilder();
		for (CuentaBancaria cuenta : cuentasBancarias){
			str.append(cuenta.toString());
		}
		return str.toString();
	}
	
	static HashSet<Cliente> clientes( ArrayList<CuentaBancaria> cuentasBancarias){
		HashSet<Cliente> clientes = new HashSet<>();
		for (CuentaBancaria cuenta : cuentasBancarias){
			clientes.add(cuenta.getCliente());
		}
		return clientes; 
	}
	
	static HashSet<Banco> bancos( ArrayList<CuentaBancaria> cuentasBancarias){
		HashSet<Banco> bancos = new HashSet<>();
		for (CuentaBancaria cuenta : cuentasBancarias){
			bancos.add(cuenta.getBanco());
		}
		return bancos; 
	}
	
	static ArrayList<TarjetaDebito> tarjetas( ArrayList<CuentaBancaria> cuentasBancarias){
		ArrayList<TarjetaDebito> tarjetas = new ArrayList<>();
		for (CuentaBancaria cuenta : cuentasBancarias){
			tarjetas.add(cuenta.getTarjeta());
		}
		return tarjetas; 
	}
		
}
