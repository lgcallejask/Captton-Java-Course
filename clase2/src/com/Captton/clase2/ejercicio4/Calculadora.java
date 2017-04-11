package com.Captton.clase2.ejercicio4;

public class Calculadora {

	public static void main(String[] args) {
		System.out.println(suma(4,5,6));
		// hacer demas ejemplos...
	}

	static int suma(int numero1, int numero2, int numero3){
		return numero1 + numero2 + numero3;
	}
	
	static float suma(float numero1, float numero2){
		return numero1 + numero2;
	}

	static float suma(float numero1, float numero2, float numero3, float numero4){
		return numero1 + numero2 + numero3+ numero4;
	}
	
	static int resta(int numero1, int numero2, int numero3){
		return numero1-numero2-numero3;
	}
	
	static float resta(float numero1, float numero2){
		return numero1-numero2;
	}
	
	static float resta(float numero1, float numero2, float numero3, float numero4){
		return numero1 - numero2 - numero3 - numero4;
	}
	
	static int multiplicacion(int numero1, int numero2, int numero3){
		return numero1*numero2*numero3;
	}
	
	static float multiplicacion(float numero1, float numero2){
		return numero1*numero2;
	}
	
	static float multiplicacion(float numero1, float numero2, float numero3, float numero4){
		return numero1 * numero2 * numero3 * numero4;
	}
	
	static float division(int numero1, int numero2, int numero3){
		return numero1/numero2/numero3;
	}
	
	static float division(float numero1, float numero2){
		return numero1/numero2;
	}
	
	static float division(float numero1, float numero2, float numero3, float numero4){
		return numero1 / numero2 / numero3 / numero4;
	}
	
}
