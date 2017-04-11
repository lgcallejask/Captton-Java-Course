package com.Captton.clase1.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		System.out.println("Ingrese un numero entero:");
		Scanner sc = new Scanner(System.in);
		int numero = Integer.parseInt(sc.nextLine());
		if (numero % 2 == 0) {
			System.out.println("El numero es par.");
		}
		else{
			System.out.println("El numero es impar.");
		}
	}

}
