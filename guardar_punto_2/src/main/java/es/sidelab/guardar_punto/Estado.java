package es.sidelab.guardar_punto;

import javax.persistence.*;
//import java.util.List;
@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	private Usuarios estado_user;

	@ManyToOne
	private Juego juegos_estado;


	@Column 
	private String estado;
	
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
