package com.Captton.clase2.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		esPalindrome("hola");
		esPalindrome("lol");
		esPalindrome("asdf");
		
	}

	public static void esPalindrome(String texto) {
		
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
