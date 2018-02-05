package es.sidelab.guardar_punto;

//import java.util.List;

import javax.persistence.*;

@Entity
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String texto;
	
	@ManyToOne
	private Juego juego;
	
	@ManyToOne
	private Usuarios user;
	
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
}
