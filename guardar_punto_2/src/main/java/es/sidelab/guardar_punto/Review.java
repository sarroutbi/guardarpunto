package es.sidelab.guardar_punto;

import java.io.Serializable;

//import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.PersistenceConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review implements Serializable{
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
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JsonIgnore
	private Juego juego;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JsonIgnore
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_juego == null) ? 0 : id_juego.hashCode());
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
		result = prime * result + ((juego == null) ? 0 : juego.hashCode());
		result = prime * result + ((primeraLinea == null) ? 0 : primeraLinea.hashCode());
		result = prime * result + ((puntuacion == null) ? 0 : puntuacion.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_juego == null) {
			if (other.id_juego != null)
				return false;
		} else if (!id_juego.equals(other.id_juego))
			return false;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		if (juego == null) {
			if (other.juego != null)
				return false;
		} else if (!juego.equals(other.juego))
			return false;
		if (primeraLinea == null) {
			if (other.primeraLinea != null)
				return false;
		} else if (!primeraLinea.equals(other.primeraLinea))
			return false;
		if (puntuacion == null) {
			if (other.puntuacion != null)
				return false;
		} else if (!puntuacion.equals(other.puntuacion))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
	
}
