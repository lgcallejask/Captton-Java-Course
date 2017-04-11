package com.Captton.clase6.TPIntegrador;

import java.util.ArrayList;

public class Empresa {
	
	static ArrayList<Cliente> clientes = new ArrayList<>();
	
	int id;
	String nombre;
	ArrayList<Producto> productos = new ArrayList<>();
	float materiaPrima;
	
	public Empresa(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.materiaPrima=0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public String agregarProducto(int id, String nombre, float precioUnitario, int stock, float costoDeMateriaPrimaUnitario){
		try{
			Empresa.comprobarExistenciaProducto(this, id);
			this.productos.add(new Manufactura(id, nombre, precioUnitario, stock, costoDeMateriaPrimaUnitario));
			return "Producto Manufactura agregado.";
		}
		catch(ExcepcionID e){
			return e.getMessage();
		}
		
	}
	
	public String agregarProducto(int id, String nombre, float precioUnitario){
		try{
			Empresa.comprobarExistenciaProducto(this, id);
			this.productos.add(new Servicio(id, nombre, precioUnitario));
			return "Producto Servicio agregado.";
		}
		catch (ExcepcionID e){
			return e.getMessage();
		}
	}

	public String agregarCliente(int id, String nombre, String apellido, float deuda, boolean discriminarIVA){
		try{
			Empresa.comprobarExistenciaCliente(this, id);
			Empresa.clientes.add(new Cliente(id, nombre, apellido, deuda, discriminarIVA));
			return "Ciente agregado.";
		}
		catch (ExcepcionID e){
			return e.getMessage();
		}
	}
		
	public Producto productoDeID(int id){
		for (Producto producto : this.productos){
			if (producto.id == id) {
				return producto;
			}
		}
		return null;
	}
	
	public Cliente clienteDeID(int id){
		for (Cliente cliente : Empresa.clientes){
			if (cliente.id == id) {
				return cliente;
			}
		}
		return null;
	}
	
	public boolean existeProductoDeID(int id){
		return (null!=productoDeID(id));
	}
	
	public boolean existeClienteDeID(int id){
		return (null!=clienteDeID(id));
	}
	
	public String vender(int idProducto, int cantidadAVender, int idCliente) {
		try{
			comprobarNoExistenciaCliente(this, idCliente);
			comprobarNoExistenciaProducto(this, idProducto);
			return this.productoDeID(idProducto).vender(cantidadAVender, this.clienteDeID(idCliente));
		}
		catch(ExcepcionID e){
			return e.getMessage();
		}
	}
	
	public String comprarMateiraPrima(Proveedor unProveedor, float unaCantidad){
		return "Se compro una cantidad de "+unaCantidad+" con un costo de "+unProveedor.vender(unaCantidad, this);
	}
	
	public String fabricarProductoDeID(int id, int unaCantidad) {
		try{
			Empresa.comprobarNoExistenciaProducto(this, id);
			Empresa.comprobarMateriaPrimaSuficiente(this, id, unaCantidad);
			return this.productoDeID(id).fabricar(unaCantidad);
		}
		catch (ExcepcionID e){
			return e.getMessage();
		}
		catch (ExcepcionMateriaPrima e){
			return e.getMessage();
		}
	}
	
	private static void comprobarMateriaPrimaSuficiente(Empresa empresa, int id, int cantidadAGenerar) throws ExcepcionMateriaPrima {
		if (empresa.materiaPrima<empresa.productoDeID(id).getCostoDeMateriaPrimaUnitario()*cantidadAGenerar) {
			throw new ExcepcionMateriaPrima("No hay materia prima suficiente.");
		}
	}

	private static void comprobarExistenciaProducto(Empresa empresa, int id) throws ExcepcionID {
		if (empresa.existeProductoDeID(id)){
			throw new ExcepcionID("Ya existe el producto en la empresa.");
		}
	}
	
	private static void comprobarNoExistenciaProducto(Empresa empresa, int id) throws ExcepcionID {
		if (!empresa.existeProductoDeID(id)){
			throw new ExcepcionID("Ya existe el producto en la empresa.");
		}
	}
	
	private static void comprobarExistenciaCliente(Empresa empresa, int id) throws ExcepcionID {
		if (empresa.existeClienteDeID(id)){
			throw new ExcepcionID("Ya existe el cliente en la empresa.");
		}	
	}
	
	private static void comprobarNoExistenciaCliente(Empresa empresa, int id) throws ExcepcionID {
		if (!empresa.existeClienteDeID(id)){
			throw new ExcepcionID("No existe el cliente en la empresa.");
		}	
	}

	
}
