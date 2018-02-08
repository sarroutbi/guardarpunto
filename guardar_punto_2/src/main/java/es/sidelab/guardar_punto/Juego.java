package es.sidelab.guardar_punto;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Juego {
	
	/*Atributos de la clase*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String title;
	
	

	@Column
	private String compannia;
	
	@Column
	private String anyo;
	
	@Column
	private String plataforma;
	
	@Column
	private Integer valoracion;
	
	@Column 
	private String genero;
	
	@Column
	private String resumen;
	
	/*Relaciones de la tabla*/
	@ManyToMany 
	private List<Usuarios> users=new ArrayList<Usuarios>();
	
	@OneToMany (mappedBy="juegos_estado")
	private List<Estado> juego_estado=new ArrayList<Estado>();
	

	@OneToMany(mappedBy="juego")
	private List<Review> reviews=new ArrayList<Review>();
	
	@OneToMany(mappedBy="juego")
	private List<Comentario> coments=new ArrayList<Comentario>();
		
	/*Handlers*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String titulo) {
		this.title = titulo;
	}

	public String getCompannia() {
		return compannia;
	}

	public void setCompannia(String companniaa) {
		compannia = companniaa;
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
		return genero;
	}

	public void setGenero(String generos) {
		genero = generos;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public List<Usuarios> getUsers() {
		return users;
	}

	public void setUsers(List<Usuarios> users) {
		this.users = users;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Comentario> getComents() {
		return coments;
	}

	public void setComents(List<Comentario> coments) {
		this.coments = coments;
	}
	
	
}
