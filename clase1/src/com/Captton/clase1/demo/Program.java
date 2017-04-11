package com.Captton.clase1.demo;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		//escritura en consola
		System.out.println("Nombre:");

		//lecturaen consola
		Scanner sc = new Scanner(System.in);
		String linea = sc.nextLine();
		
		if(!linea.equals("")){
			System.out.println("Bienvenido "+linea);
		}
		else{
			System.out.println("no ingreso ningun nombre");
		}
		
		//escritura en consola
		System.out.println("Edad:");

		//lecturaen consola
		linea = sc.nextLine();
		
		int edad = Integer.parseInt(linea);
		switch (edad){
		case 18:
			System.out.println("Es mayor.");
		case 17:
			System.out.println("Es menor de edad");
		}
		
		final int CANTIDAD_DE_ALUMNOS = 5;
		int [] edadesAlumnos = new int[CANTIDAD_DE_ALUMNOS];
		String [] nombresAlumnos = new String[CANTIDAD_DE_ALUMNOS];
		
		for (int i = 0; i < CANTIDAD_DE_ALUMNOS; i++) {
			System.out.println("Nombre:");
			nombresAlumnos[i] = sc.nextLine();
			System.out.println("Alumno:");
			edadesAlumnos[i] = Integer.parseInt(sc.nextLine());
		}
		for (int i = 0; i < CANTIDAD_DE_ALUMNOS; i++) {
			linea = String.format("Alumno: %s. Edad: %d", nombresAlumnos[i],edadesAlumnos[i]);
			System.out.println(linea);
		}
		
	}

}
