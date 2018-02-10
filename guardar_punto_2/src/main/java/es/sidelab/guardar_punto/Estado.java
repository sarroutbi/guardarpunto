package es.sidelab.guardar_punto;

import javax.persistence.*;

import org.springframework.data.annotation.PersistenceConstructor;
//import java.util.List;
@Entity@IdClass(EstadoId.class)
public class Estado {
	@Id
	@ManyToOne
	private Usuarios estado_user;
	
	@Id
	@ManyToOne
	private Juego juegos_estado;


	@Column 
	private String estado;
	
	public Estado() {
		
	}
	@PersistenceConstructor
	public Estado(Usuarios user,Juego juego,String estado) {
		estado_user = user;
		juegos_estado = juego;
		this.estado = estado;	
	}
	
	public Usuarios getEstado_user() {
		return estado_user;
	}
	public void setEstado_user(Usuarios estado_user) {
		this.estado_user = estado_user;
	}
	public Juego getJuegos_estado() {
		return juegos_estado;
	}
	public void setJuegos_estado(Juego juegos_estado) {
		this.juegos_estado = juegos_estado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
