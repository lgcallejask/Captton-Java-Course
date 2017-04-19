package com.captton.model;

import javax.persistence.*;

@Entity
@Table(name="DetallesEmpleado")
public class DetallesEmpleado {
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="pais")
	private String pais;
	
	@PrimaryKeyJoinColumn
	@OneToOne
	private Empleado empleado;
	
	public DetallesEmpleado(){
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
