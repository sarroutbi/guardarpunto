package es.sidelab.guardar_punto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	@Column
	private String biografia; 
	
	@Column
	private String imagen;
	
	/*Relaciones*/
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy="users")
	private List<Juego> juegos= new ArrayList<Juego>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy="amigos")
	private List<Usuarios> usuarios= new ArrayList<Usuarios>(); //Adri,Susi,Marta,etc
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	private List<Usuarios> amigos= new ArrayList<Usuarios>();//Amigos de adri, etc
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="user")
	private List<Comentario> coments= new ArrayList<Comentario>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="user")
	private List<Review> review= new ArrayList<Review>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="estadouser")
	private List<Estado> estados= new ArrayList<Estado>();
	
	public Usuarios() {
		
	}
	
	@PersistenceConstructor
	public Usuarios(Integer id, String biografia,String imagen) {
		super();
		this.id = id;
		this.biografia= biografia;
		this.imagen = imagen;
	}
	
	@PersistenceConstructor
	public Usuarios(String nombre, String pass, String... roles) {
		
		this.nombre = nombre;
		this.contrasenna= new BCryptPasswordEncoder().encode(pass);;
		this.roles = new ArrayList<String>(Arrays.asList(roles));
	}
	
	
	@PersistenceConstructor
	public Usuarios(Integer id,String name, String e, String c, String b,String im, String... roles) {
		super();
		
		this.id = id;
		nombre= name;
		email = e;
		contrasenna = new BCryptPasswordEncoder().encode(c);
		this.roles = new ArrayList<String>(Arrays.asList(roles));
		biografia = b;
		imagen = im;
	}
	
	/*Handlers*/
	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public List<Comentario> getComents() {
		return coments;
	}

	public void setComents(List<Comentario> coments) {
		this.coments = coments;
	}
	public void setAmigos(List<Usuarios> amigos) {
		this.amigos = amigos;
	}
	public List<Usuarios> getAmigos(){
		return amigos;
	}
	public void setEstados(List<Estado> estado) {
		estados = estado;
	}
	public List<Estado> getEstado(){
		return estados;
	}
	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Usuarios> getUsuarios(){
		return usuarios;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public void cifrarYGuardarContrasena (String pass) {
		contrasenna = new BCryptPasswordEncoder().encode(pass);
	}
	
	
	
	
	
	
}
