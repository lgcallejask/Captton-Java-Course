package com.captton.clases;

public class Localidad {
	private long id; 
	private String nombre; 
	private String ciudad;
	private String pais;
	private long cp;
	
	
	
	public Localidad(long id, String nombre, String ciudad, String pais, long cp) {
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.cp = cp;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public long getCp() {
		return cp;
	}
	public void setCp(long cp) {
		this.cp = cp;
	}
	
}
