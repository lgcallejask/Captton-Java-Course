package com.captton.clases;

public class Alumno 
{
	private long id;
	private String nombre;
	private String apellido;
	private int edad;
	private String dni;
	private long idLocalidad;
	
	public Alumno(String nombre, String apellido, int edad, String dni, long idLocalidad) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.idLocalidad = idLocalidad;
	}	
	
	public Alumno(long id, String nombre, String apellido, int edad, String dni, long idLocalidad) 
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.idLocalidad = idLocalidad;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public long getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
}
