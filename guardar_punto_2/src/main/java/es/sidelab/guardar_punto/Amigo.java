package es.sidelab.guardar_punto;

import javax.persistence.*;

import java.util.List;
import java.util.ArrayList;


@Entity
public class Amigo {
	
	@Id
	private Integer id;
	
	@ManyToMany
	private List<Usuarios> amigo =new ArrayList<Usuarios>();
	
	public Amigo (Integer i, ArrayList<Usuarios> amigos) {
		id = i;
		amigo = amigos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Usuarios> getAmigo() {
		return amigo;
	}

	public void setAmigo(List<Usuarios> amigo) {
		this.amigo = amigo;
	}
	

	
	
	
}

 
