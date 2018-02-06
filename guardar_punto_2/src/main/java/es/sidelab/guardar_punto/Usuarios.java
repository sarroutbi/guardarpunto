package es.sidelab.guardar_punto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Usuarios {

	/*Atributos*/
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
	/*Relaciones*/
	@ManyToMany(mappedBy="users")
	private List<Juego> juegos= new ArrayList<Juego>();
	
	@ManyToMany(mappedBy="usuarios")
	private List<Usuarios> amigos;
	@ManyToMany(mappedBy="amigos") /*Almacena los usuarios, para que luego pueda mapearse 
									a si misma cuando busque a los amigos*/
	private List<Usuarios> usuarios= new ArrayList<Usuarios>();
	
	@OneToMany(mappedBy="usuarios")
	private List<Comentario> coments;
	@ManyToMany
	private List<Usuarios> amigos= new ArrayList<Usuarios>();
	
	public Integer getID() {
		return id;
	@OneToMany(mappedBy="user")
	private List<Comentario> coments= new ArrayList<Comentario>();

	@OneToMany(mappedBy="user")
	private List<Review> review= new ArrayList<Review>();
	/*Handlers*/
	public List<Juego> getJuegos() {
		return juegos;
	}
	
	public void setID(int nid) {
		id=nid;

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuarios> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Usuarios> amigos) {
		this.amigos = amigos;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		
		return nombre;
	}
	
		nombre = n;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getEmail() {
		
		return email;
	}
	
		email = n;

	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		

	public String getContrasenna() {
		return contrasenna;
	}
	
	public void setContrasena(String n) {
		contrasenna = n;

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	public String getBio() {

	public String getBiografia() {
		return biografia;
	}
	
	public void setBio(String n) {
		biografia = n;

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public List<Comentario> getComents() {
		return coments;
	}

	public void setComents(List<Comentario> coments) {
		this.coments = coments;
	}
	
	
	
	
	
}
