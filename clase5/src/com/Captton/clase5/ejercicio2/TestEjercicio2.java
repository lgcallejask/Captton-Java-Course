package com.Captton.clase5.ejercicio2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEjercicio2 {
	
	Linea linea = new Linea(1, 1, 2, 2);
	
	@Test
	public void testGetPendiente() {
		assertEquals(1f, linea.getPendiente(),0f);
	}

	@Test
	public void testGetDistancia() {
		assertEquals(1.41f, linea.getDistancia(),0.01f);
	}

	@Test
	public void testEsParalela() {
		Linea linea2 = new Linea(1, 2, 2, 3);
		assertEquals(true, linea.EsParalela(linea2));
	}

}
