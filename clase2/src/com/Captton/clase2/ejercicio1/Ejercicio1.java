package com.Captton.clase2.ejercicio1;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio1 {

	public static void main(String[] args) {
	
		ArrayList<Integer> listaEnteros = new ArrayList<>();
		listaEnteros.add(25);
		listaEnteros.add(5);
		listaEnteros.add(250);
		listaEnteros.add(100);
		listaEnteros.add(150);
		System.out.println(listaEnteros);
		Collections.sort(listaEnteros);
		System.out.println(listaEnteros);
	}
	
}
