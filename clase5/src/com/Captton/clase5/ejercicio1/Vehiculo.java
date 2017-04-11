package com.Captton.clase5.ejercicio1;

import java.util.ArrayList;

abstract public class Vehiculo {

	static ArrayList<Vehiculo> vehiculos = new ArrayList<>();   
	String patente;
	boolean alquilado;
	float combustible;
	float consumoDeCombustiblePorKilometro;
	float kilometraje;
	float kilometrosAlSerAlquilado;
	float precioPorKilometraje;
	
	public Vehiculo(String patente, float combustible, float consumoDeCombustiblePorKilometro, float kilometros, float precioPorKilometraje){
		this.patente=patente;
		this.alquilado=false;
		this.combustible=combustible;
		this.consumoDeCombustiblePorKilometro=consumoDeCombustiblePorKilometro;
		this.kilometraje=kilometros;
		this.kilometrosAlSerAlquilado=0;
		this.precioPorKilometraje=precioPorKilometraje;
		Vehiculo.agregarVehiculo(this);
	}

	public void alquilar(){
		try{
			Vehiculo.comprobarSiEstaAlquilado(this);
			this.alquilado=true;
			this.kilometrosAlSerAlquilado=this.kilometraje;
		}
		catch (ExcepcionAlquilado e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void devolverVehiculo(){
		try{
			Vehiculo.comprobarSiEstaLibre(this);
			System.out.println("Costo devolucion: "+calcularCostoDevolucionVehiculo());
			this.alquilado=false;
			
		}
		catch(ExcepcionLibre e){
			System.out.println(e.getMessage());
		}
	}
	
	public float calcularCostoDevolucionVehiculo(){
		try{
			Vehiculo.comprobarKilometraje(this.kilometraje,this.kilometrosAlSerAlquilado);
		}
		catch(ExcepcionKilometraje e){
			System.out.println(e.getMessage());
		}
		return this.precioPorKilometraje*(this.kilometraje-this.kilometrosAlSerAlquilado);
	}
	
	public void andar(int kilometros){
		try{
			Vehiculo.comprobarCombustible(this.combustible, this.consumoDeCombustiblePorKilometro*kilometros);
			this.combustible-=this.consumoDeCombustiblePorKilometro*kilometros;
			this.kilometraje+=kilometros;
		}
		catch (ExcepcionCombustible e){
			System.out.println(e.getMessage());
		}
	}
	
	public void cargarCombustible(float litros){
		this.combustible+=litros;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Patente: "+this.patente+"\n");
		str.append("Alquilado: "+ this.alquilado+"\n");
		str.append("Cantidad combustible: "+combustible+"\n");
		str.append("Consumo por kilometro: "+ this.consumoDeCombustiblePorKilometro+"\n");
		str.append("kilometraje: "+kilometraje+"\n");
		str.append("Kilometraje cuando fue alquilado: "+ this.kilometrosAlSerAlquilado+"\n");
		str.append("Precio por kilometraje: "+this.precioPorKilometraje+"\n");
		return str.toString();
	}
	
	private static void comprobarKilometraje(float kilometraje, float kilometrosAlSerAlquilado) throws ExcepcionKilometraje{
		if(kilometrosAlSerAlquilado>kilometraje){
			throw new ExcepcionKilometraje("El vehiculo tiene menos kilometraje que cuando fue alquilado.");
		}
	}
	
	private static void comprobarSiEstaAlquilado(Vehiculo vehiculo) throws ExcepcionAlquilado{
		if(vehiculo.alquilado){
			throw new ExcepcionAlquilado("El vehiculo ya se encuentra alquilado.");
		}
	}
	
	private static void comprobarSiEstaLibre(Vehiculo vehiculo) throws ExcepcionLibre{
		if(!vehiculo.alquilado){
			throw new ExcepcionLibre("El vehiculo ya se encuentra disponible.");
		}
	}
	
	
	private static void comprobarCombustible(float combustibleActual, float combustibleConsumido) throws ExcepcionCombustible{
		if(combustibleConsumido > combustibleActual){
			throw new ExcepcionCombustible("No puede consumir mas combustible del que tiene.");
		}
	}
	
	private static void agregarVehiculo(Vehiculo vehiculo){
		Vehiculo.vehiculos.add(vehiculo);		
	}
	
	public static ArrayList<Vehiculo> vehiculosDisponibles(){
		ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<>();
		for (Vehiculo vehiculo : Vehiculo.vehiculos){
			if (!vehiculo.alquilado){
				vehiculosDisponibles.add(vehiculo);
			}
		}
		return vehiculosDisponibles;
	}
	
}
