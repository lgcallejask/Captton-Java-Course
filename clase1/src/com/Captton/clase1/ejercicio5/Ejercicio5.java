package com.Captton.clase1.ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		System.out.println("Ingrese un numero entero para la base de la potencia:");
		Scanner sc = new Scanner(System.in);
		int base = Integer.parseInt(sc.nextLine());
		System.out.println("Ingrese un numero entero para el exponente de la potencia:");
		int exponente = Integer.parseInt(sc.nextLine());
		int i=1;
		int acumulador=base;
		while (i<exponente){
			acumulador=acumulador*base;
			i++;
		}
		System.out.println(String.format("El resultado de la potencia con WHILE es %d", acumulador));
		acumulador=base;
		for (i = 1; i < exponente; i++) {
			acumulador=acumulador*base;
		}
		System.out.println(String.format("El resultado de la potencia con FOR es %d", acumulador));
	}

}
