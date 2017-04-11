package com.Captton.clase2.ejercicio5;

import java.util.Scanner;

public class ejercicio5 {

	public static void main(String[] args) {
		String nombre;
		String apellido;
		int dni;
		
		System.out.println("Ingrese un nombre:");
		Scanner sc = new Scanner(System.in);
		nombre = sc.nextLine();
		System.out.println("Ingrese un apellido:");
		apellido = sc.nextLine();
		System.out.println("Ingrese DNI:");
		dni = Integer.parseInt(sc.nextLine());
		
		Persona personaDeEjemplo = new Persona(nombre, apellido, dni);
		
		System.out.println(personaDeEjemplo.toString());
		
	}

}
