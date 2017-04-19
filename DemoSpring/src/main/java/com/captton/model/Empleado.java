package com.captton.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


 @Table(name="Empleado")
 @Entity

public class Empleado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column(name="telefono")
	private String telefono;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="empleado")
	private DetallesEmpleado detalle;
	
	@ManyToOne()
	@JoinColumn(name="idDepartamento")
	private Departamento dpto;
	
	@ManyToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinTable(name="ReunionEmpleado", 
	joinColumns={@JoinColumn(name="idEmpleado")},
	inverseJoinColumns={@JoinColumn(name="idReunion")})
	private List<Reunion> listaReunion = new ArrayList<Reunion>();
	
	
	public Empleado(){
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Departamento getDpto() {
		return dpto;
	}


	public void setDpto(Departamento dpto) {
		this.dpto = dpto;
	}


	public DetallesEmpleado getDetalle() {
		return detalle;
	}


	public void setDetalle(DetallesEmpleado detalle) {
		this.detalle = detalle;
	}


	public List<Reunion> getListaReunion() {
		return listaReunion;
	}


	public void setListaReunion(List<Reunion> listaReunion) {
		this.listaReunion = listaReunion;
	}
	
	
}
