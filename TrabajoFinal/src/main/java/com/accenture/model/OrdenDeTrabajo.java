package com.accenture.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="OrdenDeTrabajo")
@Entity
public class OrdenDeTrabajo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="patente")
	private String patente;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaIngreso")
	private Date fechaIngreso;
	
	@ManyToOne()
	@JoinColumn(name="idPropietario")
	private Propietario propietario;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne()
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;
	
	@Column(name="estado")
	private boolean estado;
	
	@Column(name="horasTrabajadas")
	private float horasTrabajadas;

	@Column(name="manoDeObra")
	private float manoDeObra;

	public float getManoDeObra() {
		return manoDeObra;
	}

	public void setManoDeObra(float manoDeObra) {
		this.manoDeObra = manoDeObra;
	}

	@Column(name="costoTotal")
	private float costo;
	
	
	
	@OneToMany(mappedBy="orden", orphanRemoval = true, cascade= CascadeType.REMOVE)
	private List<OrdenDeTrabajo_Repuesto> listaDetallesOrdenRepuesto = new ArrayList<OrdenDeTrabajo_Repuesto>();
	
	public OrdenDeTrabajo(){
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public float getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(float horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public List<OrdenDeTrabajo_Repuesto> getListaDetallesOrdenRepuesto() {
		return listaDetallesOrdenRepuesto;
	}

	public void setListaDetallesOrdenRepuesto(List<OrdenDeTrabajo_Repuesto> listaDetallesOrdenRepuesto) {
		this.listaDetallesOrdenRepuesto = listaDetallesOrdenRepuesto;
	}
	
}
