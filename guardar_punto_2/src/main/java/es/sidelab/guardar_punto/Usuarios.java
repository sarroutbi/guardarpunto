package es.sidelab.guardar_punto;

import java.util.List;

import javax.persistence.*;

@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private String email;
	
	@Column
	private String contrasenna;
	
	@Column
	private String biografia; 
	
	@ManyToMany(mappedBy="usuarios")
	private List<Juego> Juegos;
	
	@ManyToMany(mappedBy="usuarios")
	private List<Usuarios> amigos;
	
	@OneToMany(mappedBy="usuarios")
	private List<Comentario> coments;
	
	public Integer getID() {
		return id;
	}
	
	public void setID(int nid) {
		id=nid;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public void setNombre(String n) {
		nombre = n;
	}
	
	public String getEmail() {
		
		return email;
	}
	
	public void setEmail(String n) {
		email = n;
	}
	public String getContrasena() {
		
		return contrasenna;
	}
	
	public void setContrasena(String n) {
		contrasenna = n;
	}
	public String getBio() {
		
		return biografia;
	}
	
	public void setBio(String n) {
		biografia = n;
	}
	
	
	
}
