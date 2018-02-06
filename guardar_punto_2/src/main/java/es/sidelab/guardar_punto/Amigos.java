package es.sidelab.guardar_punto;

import java.util.List;

import javax.persistence.*;

@Entity
public class Amigos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAmigo;
	
	@ManyToMany
	private List<Usuarios> amigos;
}
