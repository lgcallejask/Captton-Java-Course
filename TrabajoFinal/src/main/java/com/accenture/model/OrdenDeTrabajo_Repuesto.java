package com.accenture.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="OrdenDeTrabajo_Repuesto")
@Entity
public class OrdenDeTrabajo_Repuesto implements Serializable{

	@Id
	@ManyToOne()
	@JoinColumn(name="idOrdenDeTrabajo")
	private OrdenDeTrabajo orden;
	
	@Id
	@ManyToOne()
	@JoinColumn(name="idRepuesto")
	private Repuesto repuesto;
	
	@Column(name="cantidadUsadaDeRepuesto")
	private int cantidadUsadaDeRepuesto;
	
	@Column(name="costoDetalle")
	private float costo;

	public OrdenDeTrabajo_Repuesto() {
	}

	public OrdenDeTrabajo getOrden() {
		return orden;
	}

	public void setOrden(OrdenDeTrabajo orden) {
		this.orden = orden;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public int getCantidadUsadaDeRepuesto() {
		return cantidadUsadaDeRepuesto;
	}

	public void setCantidadUsadaDeRepuesto(int cantidadUsadaDeRepuesto) {
		this.cantidadUsadaDeRepuesto = cantidadUsadaDeRepuesto;
	}
	
	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	
}
