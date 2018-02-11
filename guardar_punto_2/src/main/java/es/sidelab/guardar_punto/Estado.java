package es.sidelab.guardar_punto;

//import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.annotation.PersistenceConstructor;
//import java.util.List;

//@IdClass(EstadoId.class)
@Entity
public class Estado {
	
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
	
}
