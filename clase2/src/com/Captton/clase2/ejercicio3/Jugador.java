package com.Captton.clase2.ejercicio3;

import java.util.ArrayList;

public class Jugador {
	
	String nombre;
	String apellido;
	Club club;
	ArrayList<Auto> autos;
	float salario;
	int cantidadGoles;
	int cantidadTarjetasAmarillas;
	int cantidadTarjetasRojas;
	
	public Jugador(){}
	public Jugador(String nombre, String apellido, Club club, float salario, int cantidadGoles,
			int cantidadTarjetasAmarillas, int cantidadTarjetasRojas) {
		this.nombre = nombre;
		this.apellido = apellido;		
		this.club = club;
		club.plantel.add(this);
		this.autos = new ArrayList<Auto>();
		this.salario = salario;
		this.cantidadGoles = cantidadGoles;
		this.cantidadTarjetasAmarillas = cantidadTarjetasAmarillas;
		this.cantidadTarjetasRojas = cantidadTarjetasRojas;
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

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public ArrayList<Auto> getAutos() {
		return autos;
	}

	public void setAutos(ArrayList<Auto> autos) {
		this.autos = autos;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getCantidadGoles() {
		return cantidadGoles;
	}

	public void setCantidadGoles(int cantidadGoles) {
		this.cantidadGoles = cantidadGoles;
	}

	public int getCantidadTarjetasAmarillas() {
		return cantidadTarjetasAmarillas;
	}

	public void setCantidadTarjetasAmarillas(int cantidadTarjetasAmarillas) {
		this.cantidadTarjetasAmarillas = cantidadTarjetasAmarillas;
	}

	public int getCantidadTarjetasRojas() {
		return cantidadTarjetasRojas;
	}

	public void setCantidadTarjetasRojas(int cantidadTarjetasRojas) {
		this.cantidadTarjetasRojas = cantidadTarjetasRojas;
	}

	public void ficharEnUnClub(Club unClub){
		this.club.reomverJugador(this);
		this.setClub(unClub);
		unClub.agregarJugador(this);
	}

	public void romperContratoConUnClub(Club unClub){
		
	}
	
	public void sumarGol(){
		this.setCantidadGoles(this.getCantidadGoles()+1);
		this.incrementarSalarioUnPorcentaje(5);
	}
	
	private void incrementarSalarioUnPorcentaje(int porcentaje) {
		this.setSalario(this.getSalario()*(1+(float)porcentaje/100));		
	}

	public void sumarTarjetaRoja(){
		this.setCantidadTarjetasRojas(this.getCantidadTarjetasRojas()+1);
		this.disminuiurSalarioUnPorcentaje(5);
	}
	
	private void disminuiurSalarioUnPorcentaje(int porcentaje) {
		this.setSalario(this.getSalario()*(1-(float)porcentaje/100));
	}

	public void sumarTarjetaAmarilla(){
		this.setCantidadTarjetasAmarillas(getCantidadTarjetasAmarillas()+1);
	}
	
	public void comprarAuto(Auto unAuto){
		this.getAutos().add(unAuto);
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Nombre: "+this.nombre+"\n");
		str.append("Apellido: "+this.apellido+"\n");
		str.append("Club: "+this.club.nombre+"\n");
		str.append("Autos:\n"+this.autos+"\n");
		str.append("Salario: "+this.salario+"\n");
		str.append("Cantidad de goles: "+this.cantidadGoles+"\n");
		str.append("Tarjetas Amarillas: "+this.cantidadTarjetasAmarillas+"\n");
		str.append("Tarjetas Rojas: "+this.cantidadTarjetasRojas+"\n");
		return str.toString();
	}
	
}

