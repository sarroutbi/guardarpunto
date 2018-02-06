package es.sidelab.guardar_punto;

//import java.util.List;

import javax.persistence.*;

@Entity
public class Review {
	/*Atributos de la entidad*/	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String texto;
	
	@Column
	private Float puntuacion;
	
	/*Relaciones de la clase*/
	
	@ManyToOne
	private Juego juego;
	
	@ManyToOne
	private Usuarios user;
	
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
	
	
	
}
