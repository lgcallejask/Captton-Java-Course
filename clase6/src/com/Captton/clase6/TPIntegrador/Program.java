package com.Captton.clase6.TPIntegrador;

public class Program {

	public static void main(String[] args) {
		
		MateriaPrima highPerformance = new MateriaPrima(1, "High Performance", 100);
		Proveedor proveedor1 = new Proveedor(1, "ACN", highPerformance);
		
		Empresa empresa1 = new Empresa(1, "Captton");
		
		System.out.println("------Pruebas del metodo Agregar Cliente:");
		System.out.println(empresa1.agregarCliente(1, "Lucas","Calle", 0, false));
		System.out.println(empresa1.agregarCliente(2, "Lean","Captton", 0, true));
		System.out.println(empresa1.agregarCliente(3, "Mati","Captton", 9999, false));		
		System.out.println(empresa1.agregarCliente(3, "ID duplicado","Se espera error", 9999, false));
		System.out.println();
		
		System.out.println("------Pruebas del metodo Agregar Producto:");
		System.out.println(empresa1.agregarProducto(1, "Heladera", 7500, 100, 50));
		System.out.println(empresa1.agregarProducto(2, "Radio", 100, 1, 1));
		System.out.println(empresa1.agregarProducto(3, "Instalacion aireacondicionado", 350));
		System.out.println(empresa1.agregarProducto(3, "ID duplicado se espera error", 350));
		System.out.println();
	
		System.out.println("------Pruebas del metodo Venta:");
		System.out.println("");
		System.out.println("---Venta a un cliente sin IVA discriminado:");
		System.out.println(empresa1.vender(1, 5, 1));
		System.out.println();		
		System.out.println("---Venta a un cliente con IVA discriminado:");
		System.out.println(empresa1.vender(1, 5, 2));
		System.out.println();
		System.out.println("---Venta a un cliente Deudor:");
		System.out.println(empresa1.vender(1, 5, 3));
		System.out.println();
		System.out.println("---Venta a un cliente inexistente:");
		System.out.println(empresa1.vender(1, 5, 4));
		System.out.println();
		System.out.println("---Venta de un producto sin Stock:");
		System.out.println(empresa1.vender(2, 5, 1));
		System.out.println();
		System.out.println("---Venta de servicio:");
		System.out.println(empresa1.vender(3, 5, 1));
		System.out.println();
				
		System.out.println("------Prueba del metodo comprar materia prima:");
		System.out.println("");
		System.out.println(empresa1.comprarMateiraPrima(proveedor1, 100));
		System.out.println();
		
		System.out.println("------Pruebas del metodo Fabricar Producto:");
		System.out.println("");
		System.out.println("---Fabicar producto con materia Prima Sufuciente:");
		System.out.println(empresa1.fabricarProductoDeID(1,2));
		System.out.println();
		System.out.println("---Fabicar producto sin materia Prima Sufuciente:");
		System.out.println(empresa1.fabricarProductoDeID(1,22));
		System.out.println();
		
	}

}
