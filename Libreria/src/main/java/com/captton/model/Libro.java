package com.captton.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Table(name="Libro")
@Entity
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="idEditorial")
	private int idEditorial;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;
	
	//* - 1 
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idEditorial")
	private Editorial editorial;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="Libro_Autor",
        joinColumns={@JoinColumn(name="idLibro")},
        inverseJoinColumns={@JoinColumn(name="idAutor")}
    )
	private ArrayList<Autor> listaAutores = new ArrayList();
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="Libro_Genero",
        joinColumns={@JoinColumn(name="idGenero")},
        inverseJoinColumns={@JoinColumn(name="idLibro")}
    )
	private ArrayList<Genero> listaGeneros = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public ArrayList<Autor> getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(ArrayList<Autor> listaAutores) {
		this.listaAutores = listaAutores;
	}

	public ArrayList<Genero> getListaGeneros() {
		return listaGeneros;
	}

	public void setListaGeneros(ArrayList<Genero> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}
	
	
	
	
}
