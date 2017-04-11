package com.Captton.clase3.ejercicio3;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Lucas", "Callejas", 12345678);
		Cliente cliente2 = new Cliente("Leandro", "Captton", 25363170);
		Cliente cliente3 = new Cliente("Matias", "Captton", 12247357);
		
		Banco banco1 = new Banco("Galicia");
		Banco banco2 = new Banco("Itau");
		
		banco1.darAltaCliente(cliente1);
		banco1.darAltaCliente(cliente2);
		banco2.darAltaCliente(cliente2);
		banco2.darAltaCliente(cliente3);
		
		cliente1.depositarEnCuenta(cliente1.cuentasBancarias.get(0), 90000);
		cliente2.depositarEnCuenta(cliente2.cuentasBancarias.get(0), 50000);
		cliente2.depositarEnCuenta(cliente2.cuentasBancarias.get(1), 75000);
		cliente3.depositarEnCuenta(cliente3.cuentasBancarias.get(0), 10);
		
		System.out.print("Datos Cliente: ");
		System.out.println(cliente1.toString());
		System.out.println();
		System.out.println("Cuentas que tiene:");
		System.out.println(cliente1.cuentas());
		System.out.print("Monto total de las cuentas: ");
		System.out.println(cliente1.montoTotalDeCuentas());
		System.out.println();
		System.out.println("Bancos de los que es cliente: ");
		System.out.println(cliente1.bancosDeLosQueEsCliente());
		System.out.println("Tarjetas que tiene: ");
		System.out.println(cliente1.tarjetasQueTiene());
		System.out.println("--------------------------------");
		
		System.out.print("Datos Cliente: ");
		System.out.println(cliente2.toString());
		System.out.println();
		System.out.println("Cuentas que tiene:");
		System.out.println(cliente2.cuentas());
		System.out.print("Monto total de las cuentas: ");
		System.out.println(cliente2.montoTotalDeCuentas());
		System.out.println();
		System.out.println("Bancos de los que es cliente: ");
		System.out.println(cliente2.bancosDeLosQueEsCliente());
		System.out.println("Tarjetas que tiene: ");
		System.out.println(cliente2.tarjetasQueTiene());
		System.out.println("--------------------------------");
		
		System.out.print("Datos Cliente: ");
		System.out.println(cliente3.toString());
		System.out.println();
		System.out.println("Cuentas que tiene:");
		System.out.println(cliente3.cuentas());
		System.out.print("Monto total de las cuentas: ");
		System.out.println(cliente3.montoTotalDeCuentas());
		System.out.println();
		System.out.println("Bancos de los que es cliente: ");
		System.out.println(cliente3.bancosDeLosQueEsCliente());
		System.out.println("Tarjetas que tiene: ");
		System.out.println(cliente3.tarjetasQueTiene());
		System.out.println("--------------------------------");
		
		System.out.print("Banco: ");
		System.out.println(banco1.toStirng());
		System.out.println("");
		System.out.println("Clientes: ");
		System.out.println(banco1.clientes());
		System.out.println("Tarjetas emitidas: ");
		System.out.println(banco1.tarjetasEmitidas());
		System.out.println("Cuentas activas: ");
		System.out.println(banco1.cuentas());
		System.out.println("--------------------------------");
		
		System.out.print("Banco: ");
		System.out.println(banco2.toStirng());
		System.out.println("");
		System.out.println("Clientes: ");
		System.out.println(banco2.clientes());
		System.out.println("Tarjetas emitidas: ");
		System.out.println(banco2.tarjetasEmitidas());
		System.out.println("Cuentas activas: ");
		System.out.println(banco2.cuentas());
		System.out.println("--------------------------------");
		
	}

}
