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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="Libro")
public class Libro {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@JoinColumn(name="idEditorial")
	@ManyToOne(cascade=CascadeType.ALL)
	private Editorial editorial;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="Libro_Genero",
			joinColumns={@JoinColumn(name="idLibro")},
			inverseJoinColumns={@JoinColumn(name="idGenero")}
	)
		
	private List<Genero> listaGenero = new ArrayList();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="Libro_Autor",
		joinColumns={@JoinColumn(name="idLibro")},
		inverseJoinColumns={@JoinColumn(name="idAutor")}
	)
	
	private List<Autor> listaAutor = new ArrayList();
	
	public Libro(){}

	
	
	
	
	public Libro(String titulo, Editorial editorial, Date fecha, List<Genero> listaGenero,
			List<Autor> listaAutor) {
		this.id = 0L;
		this.titulo = titulo;
		this.editorial = editorial;
		this.fecha = fecha;
		this.listaGenero = listaGenero;
		this.listaAutor = listaAutor;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha_edicion(Date fecha) {
		this.fecha = fecha;
	}

	public List<Genero> getListaGenero() {
		return listaGenero;
	}

	public void setListaGenero(List<Genero> listaGenero) {
		this.listaGenero = listaGenero;
	}

	public List<Autor> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}
	
	
}
