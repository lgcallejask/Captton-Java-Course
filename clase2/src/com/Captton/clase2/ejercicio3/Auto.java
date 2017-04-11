package com.Captton.clase2.ejercicio3;

public class Auto {

	public String marca;
	public String modelo;
	public String patente;
	
	public Auto(String marca, String modelo, String patente) {
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Marca: "+this.marca+"\n");
		str.append("Modelo: "+this.modelo+"\n");
		str.append("Patente: "+this.patente+"\n");
		return str.toString();
	}
	
	
}
