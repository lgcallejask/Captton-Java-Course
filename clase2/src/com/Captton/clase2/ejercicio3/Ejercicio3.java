package com.Captton.clase2.ejercicio3;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Club club1 = new Club("Globito");
		Club club2 = new Club("Yupanqui");
				
		Auto auto1 = new Auto("BMW", "LaPosta", "AWD 325");
		Auto auto2 = new Auto("FIAT", "Palo", "BRJ 865");
		Auto auto4 = new Auto("VW", "Golazoa", "IFI 186");
		Auto auto5 = new Auto("VW", "BoraBora", "OBT 983");
		Auto auto6 = new Auto("Ferrari", "Testarosa", "NHD 371");
		
		Jugador jugador1 = new Jugador("Lucas", "Calle", club1, 1000, 1000, 4, 0);
		Jugador jugador2 = new Jugador("Leandro", "Captton", club1, 2000, 1, 27, 15);
		Jugador jugador3 = new Jugador("Matias", "Captton", club2, 3000, 2, 11, 3);
		Jugador jugador4 = new Jugador("Pepe", "Argento", club2, 40000, 3, 114, 35);
		
		System.out.println("--------------------------------");
		System.out.println("DATOS DEL club1:");
		System.out.println(club1.toString());
		System.out.println("--------------------------------");
		System.out.println("DATOS DEL jugador1:");
		System.out.println(jugador1.toString());
		System.out.println("--------------------------------");
		
		jugador1.sumarGol();
		
		System.out.println("DATOS DEL jugador1 DESPUES DE GOL (%5 de sueldo extra):");
		System.out.println(jugador1.toString());
		System.out.println("--------------------------------");
		
		jugador1.sumarTarjetaRoja();
		
		System.out.println("DATOS DEL jugador1 DESPUES DE ROJA (%5 de sueldo menos):");
		System.out.println(jugador1.toString());
		System.out.println("--------------------------------");
		
		jugador1.ficharEnUnClub(club2);
		
		System.out.println("DATOS DEL jugador1 DESPUES DE FICHAR EN club2:");
		System.out.println(jugador1.toString());
		System.out.println("--------------------------------");
		
		System.out.println("DATOS DE club2 DESPUES DE FICHAR:");
		System.out.println(club2.toString());
		System.out.println("--------------------------------");
		
		jugador1.comprarAuto(auto4);
		jugador1.comprarAuto(auto5);
		
		System.out.println("DATOS DEL jugador1 DESPUES DE COMPRAR auto5:");
		System.out.println(jugador1.toString());
		System.out.println("--------------------------------");
		
		System.out.println("TARJETAS AMARILLAS DE club1 Y club2:");
		System.out.println(club1.getNombre()+": "+club1.tarjetasAmarillasDelPlantel());
		System.out.println(club2.getNombre()+": "+club2.tarjetasAmarillasDelPlantel());
		
	}

}
