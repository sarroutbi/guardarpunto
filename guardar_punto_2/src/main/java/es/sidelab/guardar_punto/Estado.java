package es.sidelab.guardar_punto;

import java.io.Serializable;

//import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.annotation.PersistenceConstructor;
//import java.util.List;

//@IdClass(EstadoId.class)
@Entity
public class Estado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@Id
	@ManyToOne
	private Usuarios estadouser;
	
	//@Id
	@ManyToOne
	private Juego juegosestado;
    

	@Column 
	private String state;
	
	
	public Estado() {
		
	}
	
	@PersistenceConstructor
	public Estado(Usuarios user,Juego juego,String estado) {
		estadouser = user;
		juegosestado = juego;
		
		this.state = estado;	
	}
	
	public Usuarios getEstado_user() {
		return estadouser;
	}
	public void setEstado_user(Usuarios estado_user) {
		this.estadouser = estado_user;
	}
	public Juego getJuegos_estado() {
		return juegosestado;
	}
	public void setJuegos_estado(Juego juegos_estado) {
		this.juegosestado = juegos_estado;
	}
	public String getEstado() {
		return state;
	}
	public void setEstado(String estado) {
		this.state = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadouser == null) ? 0 : estadouser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((juegosestado == null) ? 0 : juegosestado.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Estado other = (Estado) obj;
		if (estadouser == null) {
			if (other.estadouser != null)
				return false;
		} else if (!estadouser.equals(other.estadouser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (juegosestado == null) {
			if (other.juegosestado != null)
				return false;
		} else if (!juegosestado.equals(other.juegosestado))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	
	
}
