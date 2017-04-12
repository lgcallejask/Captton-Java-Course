package com.captton.model;

import java.util.ArrayList;
import javax.persistence.*;

@Table(name="Editorial")
@Entity
public class Editorial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	//1 - * 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Libro",
    joinColumns={@JoinColumn(name="id")},
    inverseJoinColumns={@JoinColumn(name="idEditorial")})
	private ArrayList<Libro> listaLibros = new ArrayList();

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

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
}
