package com.Captton.clase1.ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		System.out.println("Ingrese un numero entero: ");
		Scanner sc = new Scanner(System.in);
		int numero = Integer.parseInt(sc.nextLine());
		float acumulador=0;
		float i;
		for ( i=1; i <= numero; i++) {
			acumulador=acumulador+i;
		} 
		i--;
		System.out.println(String.format("La sumatoria es %.0f.", acumulador));
		System.out.println(String.format("El promedio es %.2f.", (acumulador/i)));
	}

}
