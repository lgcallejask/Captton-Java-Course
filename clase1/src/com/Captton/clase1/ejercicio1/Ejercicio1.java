package com.Captton.clase1.ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		System.out.println("Ingrese su nombre:");
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		System.out.println("Ingrese su edad:");
		int edad = Integer.parseInt(sc.nextLine());
		System.out.println(String.format("Bienvenido usuario %s con %d años!", nombre, edad));		
	}

}
