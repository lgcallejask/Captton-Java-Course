package javarsc;

public class Libro {
	private String titulo;
	private String autor;
	private String editorial;
	private Integer año;	
	
	public Libro(String titulo, String autor, String editorial, Integer año) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.año = año;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
}
