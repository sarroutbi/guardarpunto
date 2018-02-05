package es.sidelab.guardar_punto;

import javax.persistence.*;

import java.util.List;

@Entity
public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String Titulo;
	
	@Column
	private String Compannia;
	
	@Column
	private String anyo;
	
	@Column
	private String plataforma;
	
	@Column
	private Integer valoracion;
	
	@Column 
	private String Genero;
	
	@Column
	private String resumen;
	
	
	@ManyToMany(mappedBy="juego")
	private List<Usuarios> users;
	
	@OneToMany(mappedBy="juego")
	private List<Review> reviews;
	
	@OneToMany(mappedBy="juego")
	private List<Comentario> coments;
		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getCompannia() {
		return Compannia;
	}

	public void setCompannia(String compannia) {
		Compannia = compannia;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	
	
}
