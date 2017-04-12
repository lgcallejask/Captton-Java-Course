package com.captton.model;

import java.util.ArrayList;

import javax.persistence.*;

@Table(name="Genero")
@Entity
public class Genero {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="Libro_Genero",
        joinColumns={@JoinColumn(name="idGenero")},
        inverseJoinColumns={@JoinColumn(name="idLibro")}
    )
	private ArrayList<Genero> listaLibros = new ArrayList();

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

	public ArrayList<Genero> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Genero> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	
}
