package com.Captton.clase2.ejercicio3;

import java.util.ArrayList;

public class Club {

	String nombre;
	ArrayList<Jugador> plantel;
	
	public Club(String nombre) {
		this.nombre = nombre;
		this.plantel = new ArrayList<Jugador>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getPlantel() {
		return plantel;
	}

	public void setPlantel(ArrayList<Jugador> plantel) {
		this.plantel = plantel;
	}

	public void agregarJugador(Jugador unJugador) {
		this.plantel.add(unJugador);
	}

	public void reomverJugador(Jugador jugador) {
		this.plantel.remove(this.plantel.indexOf(jugador));
		
	}
	
	public int tarjetasAmarillasDelPlantel(){
		int acumulador=0;
		for (Jugador unJugador  : this.getPlantel()) {
			acumulador = acumulador + unJugador.cantidadTarjetasAmarillas;
		}
		return acumulador;
	}
	
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Nombre: "+this.nombre+"\n");
		str.append("Jugadores:\n"+this.plantel);
		return str.toString();
	}
	
}
