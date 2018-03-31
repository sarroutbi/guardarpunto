package es.sidelab.guardar_punto;

import java.io.Serializable;

//import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
public class Comentario implements Serializable {
	
	/*Atributos*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String texto;
	
	/*Relaciones*/
	@ManyToOne
	private Juego juego;
	
	@ManyToOne
	private Usuarios user;
	
	//Variables para añadir nuevos comentarios desde la ficha del juego 
	private String id_juego, id_usuario;	

	public Comentario () {
		
	}
	
	@PersistenceConstructor
	public Comentario (String t) {
		super();
		texto = t;
	}
	
	/*Handlers*/
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
	
	//Para añadir nuevos comentarios desde la ficha del juego 
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_juego == null) ? 0 : id_juego.hashCode());
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
		result = prime * result + ((juego == null) ? 0 : juego.hashCode());
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
		Comentario other = (Comentario) obj;
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
