package com.Captton.clase1.ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		System.out.println("Ingrese un numero del 0 al 9:");
		Scanner sc = new Scanner(System.in);
		int numero = Integer.parseInt(sc.nextLine());
		switch (numero){
		case 0: {
			System.out.println("CERO");
			break;
		}
		case 1: {
			System.out.println("UNO");
			break;
		}
		case 2: {
			System.out.println("DOS");
			break;
		}
		case 3: {
			System.out.println("TRES");
			break;
		}
		case 4: {
			System.out.println("CUATRO");
			break;
		}
		case 5: {
			System.out.println("CINCO");
			break;
		}
		case 6: {
			System.out.println("SEIS");
			break;
		}
		case 7: {
			System.out.println("SIETE");
			break;
		}
		case 8: {
			System.out.println("OCHO");
			break;
		}
		case 9: {
			System.out.println("NUEVE");
			break;
		}
		default: {
			System.out.println("No ingreso un numero entre el 0 y el 9·");
		}
		}
	}

}
