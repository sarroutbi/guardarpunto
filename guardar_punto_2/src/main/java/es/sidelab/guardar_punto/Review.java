package es.sidelab.guardar_punto;

//import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
public class Review {
	/*Atributos de la entidad*/	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String texto;
	private String primeraLinea;
	
	@Column
	private Float puntuacion;
	
	/*Relaciones de la clase*/
	
	@ManyToOne
	private Juego juego;
	
	@ManyToOne
	private Usuarios user;
	
	//Variables para añadir nuevas reviews desde la ficha del juego 
	private String id_juego, id_usuario;	
	
	public Review () {
		
	}
	
	@PersistenceConstructor
	public Review (String t, Float p) {
		super();
		texto = t;
		puntuacion = p;
		primeraLinea = texto.substring(0, 10);
	}
	
	/*Handlers*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Float getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Usuarios getUser() {
		return user;
	}

	public void setUser(Usuarios user) {
		this.user = user;
	}
	
	//Para añadir nuevas reviews desde la ficha del juego 
	
	public String getId_juego() {
		return id_juego;
	}

	public void setId_juego(String id_juego) {
		this.id_juego = id_juego;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getPrimeraLinea() {
		return primeraLinea;
	}

	public void setPrimeraLinea(String primeraLinea) {
		this.primeraLinea = primeraLinea;
	}
	
	
	
	
}
