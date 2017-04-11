package com.Captton.clase5.ejercicio2;

public class Linea {

	private double x0, y0, x1, y1;
		
	// Constructor de la Linea
	public Linea(double x0, double y0, double x1, double y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	// Calcular la inclinacion de la linea
	public double getPendiente( ) {
		if(x1 == x0) {
			throw new ArithmeticException( );
		}
		return (y1 - y0) / (x1 - x0);
	}

	// Calcular el largo de la linea
	public double getDistancia( ) {
		return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
	}

	// Calular si dos lineas son paralelas
	public boolean EsParalela(Linea l) {
		//Si la diferencia entre las inclinaciones es minima, considerarlas paralelas
		if(Math.abs(getPendiente( ) - l.getPendiente( )) < .0001) {
			return true;
		} else {
			return false;
		}
	}
}

