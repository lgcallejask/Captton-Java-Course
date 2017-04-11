package com.Captton.clase1.ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		System.out.println("Ingrese una frase o palabra:");
		Scanner sc = new Scanner(System.in);
		String texto = sc.nextLine().replaceAll(" ", "");
		String textoAux="";
		for(int i=texto.length()-1,j=0;i>=0;i--,j++){
			textoAux += texto.charAt(i);
		}
		
		if(texto.toString().contentEquals(textoAux.toString()))
		{
			System.out.println("Es palindrome.");
		}
		else {
			System.out.println("No es palindrome");
		}
		System.out.println(texto);
		System.out.println(textoAux);
	}

}
