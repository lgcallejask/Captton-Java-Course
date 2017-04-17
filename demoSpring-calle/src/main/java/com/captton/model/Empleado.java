package com.captton.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Table(name="Empleado")
@Entity
public class Empleado
{
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
	
	//1 - 1 
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="empleado")
	private DetallesEmpleado detalle;

	// * - 1
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idDepartamento")
	private Departamento dpto;
	
	//Muchos a Muchos
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="ReunionEmpleado",
        joinColumns={@JoinColumn(name="idEmpleado")},
        inverseJoinColumns={@JoinColumn(name="idReunion")}
    )
	private List<Reunion> listaReunion = new ArrayList();
	
	public Empleado(){}
	
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

	public DetallesEmpleado getDetalle() {
		return detalle;
	}

	public void setDetalle(DetallesEmpleado detalle) {
		this.detalle = detalle;
	}

	public Departamento getDpto() {
		return dpto;
	}

	public void setDpto(Departamento dpto) {
		this.dpto = dpto;
	}

	public List<Reunion> getListaReunion() {
		return listaReunion;
	}

	public void setListaReunion(List<Reunion> listaReunion) {
		this.listaReunion = listaReunion;
	}

		
}
