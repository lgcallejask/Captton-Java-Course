package com.accenture.model;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Repuesto")
@Entity
public class Repuesto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private float precio;
	
	@ManyToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinTable(name="OrdenDeTrabajo_Repuesto", 
	joinColumns={@JoinColumn(name="idRepuesto")},
	inverseJoinColumns={@JoinColumn(name="idOrdenDeTrabajo")})
	private List<Repuesto> listaRepuestos = new ArrayList<Repuesto>();
	
	@OneToMany(mappedBy="repuesto", orphanRemoval = true, cascade= CascadeType.REMOVE)
	private List<OrdenDeTrabajo_Repuesto> listaDetallesOrdenRepuesto = new ArrayList<OrdenDeTrabajo_Repuesto>();
	
	public Repuesto() {
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<Repuesto> getListaRepuestos() {
		return listaRepuestos;
	}

	public void setListaRepuestos(List<Repuesto> listaRepuestos) {
		this.listaRepuestos = listaRepuestos;
	}

	public List<OrdenDeTrabajo_Repuesto> getListaDetallesOrdenRepuesto() {
		return listaDetallesOrdenRepuesto;
	}

	public void setListaDetallesOrdenRepuesto(List<OrdenDeTrabajo_Repuesto> listaDetallesOrdenRepuesto) {
		this.listaDetallesOrdenRepuesto = listaDetallesOrdenRepuesto;
	}
	
}
