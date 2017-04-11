package com.Captton.clase1.ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		System.out.println("Ingrese un numero entero a buscar en el array:");
		Scanner sc = new Scanner(System.in);
		int numero = Integer.parseInt(sc.nextLine());
		int [] unArraySimple = {1,2,3,4,5};
		int i;
		for ( i = 0; i < unArraySimple.length; i++) {
			if (numero == unArraySimple[i]) {
				System.out.println(i);
				break;
			}
		}
		if (i==unArraySimple.length){
			System.out.println(-1);
		}
	}

}
