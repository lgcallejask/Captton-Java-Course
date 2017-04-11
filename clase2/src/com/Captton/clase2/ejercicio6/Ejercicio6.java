package com.Captton.clase2.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		ArrayList<Integer> listaEnteros = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese 10 numeros separados por coma: ");
		String numeros = sc.nextLine().replace(",", " ").trim()+" ";
		
		int i = 0;
		int comienzo = 0;
		int ultimoCaracter;
		while (i < numeros.length()) {
			i++;
			ultimoCaracter=i;
			char resultadoDeCharAt;
			if (numeros.charAt(i)==' ' || i==numeros.length()-1){
				int aux=0;
				aux=Integer.parseInt(numeros.substring(comienzo,ultimoCaracter));
				listaEnteros.add(aux);
				comienzo=++i;
			}
		}
		
		Collections.sort(listaEnteros);
		
		for (int numero : listaEnteros){
			System.out.println(numero);
			sc.nextLine();
		}
		
	}

}
