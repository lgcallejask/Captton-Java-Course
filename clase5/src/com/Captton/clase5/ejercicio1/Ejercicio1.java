package com.Captton.clase5.ejercicio1;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Auto vehiculo1 = new Auto("AAA 111", 100, 2, 1000);
		Moto vehiculo2 = new Moto("MMM 222", 100, 3, 2000);
		Camion vehiculo3 = new Camion("CCC 333", 100, 5, 100);
		
		System.out.println("Veiculos:");
		System.out.println(Vehiculo.vehiculos);
		
		vehiculo1.alquilar();
		vehiculo1.andar(10);
		
		System.out.println("Costo del Auto por 10Km: ");
		System.out.println(vehiculo1.calcularCostoDevolucionVehiculo());
		
		vehiculo2.alquilar();
		vehiculo2.andar(10);
		
		System.out.println("Costo de la Moto por 10Km: ");
		System.out.println(vehiculo2.calcularCostoDevolucionVehiculo());
		
		vehiculo3.alquilar();
		vehiculo3.andar(5);
		
		System.out.println("Costo del Camion por 5Km: ");
		System.out.println(vehiculo3.calcularCostoDevolucionVehiculo());
		
		System.out.println("Vehiculos disponibles: "+Vehiculo.vehiculosDisponibles());
		
		vehiculo1.andar(999999); //Error por combustible
		vehiculo2.alquilar(); //Error por alquiler
		vehiculo3.devolverVehiculo();
		vehiculo3.devolverVehiculo(); //Error por devolucion
		vehiculo2.kilometraje=5;
		vehiculo2.devolverVehiculo(); //Error por kilometraje		
		
	}

}
