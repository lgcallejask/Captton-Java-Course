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
	
	@Column(name="cantiedadUsadaDeRepuesto")
	private String cantiedadUsadaDeRepuesto;
	
	public OrdenDeTrabajo_Repuesto() {
	}
	
}
