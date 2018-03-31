package es.sidelab.guardar_punto;

import javax.persistence.*;

import org.springframework.data.annotation.PersistenceConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Juego implements Serializable {
	
	/*Atributos de la clase*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String title;	

	@Column
	private String compannia;
	
	@Column
	private String anyo;
	
	@Column
	private String plataforma;
	
	@Column
	private float valoracion;
	
	@Column 
	private String genero;
	
	@Column
	private String resumen;
	
	@Column
	private String imagen;
	
	//Variables para calcular la media
	@Column 
	private int nVotos = 0;
	@Column 
	private float votosTotal = 0.0f;
	
	/*Relaciones de la tabla*/
	@ManyToMany 
	private List<Usuarios> users=new ArrayList<Usuarios>();
	
	@OneToMany (mappedBy="juegosestado")
	private List<Estado> juego_estado=new ArrayList<Estado>();
	
	@OneToMany(mappedBy="juego")
	private List<Review> reviews=new ArrayList<Review>();
	
	@OneToMany(mappedBy="juego")
	private List<Comentario> coments=new ArrayList<Comentario>();
	
	public Juego () {
		
	}
	
	@PersistenceConstructor
	public Juego (String t, String c, String a, String p, float v, String g, String r, String im) {
		super ();
		
		title = t;
		compannia = c;
		anyo = a;
		plataforma = p;
		valoracion = v;
		genero = g;
		resumen = r;	
		imagen = im;
	}
		
	/*Handlers*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String titulo) {
		this.title = titulo;
	}

	public String getCompannia() {
		return compannia;
	}

	public void setCompannia(String companniaa) {
		compannia = companniaa;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String generos) {
		genero = generos;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public List<Usuarios> getUsers() {
		return users;
	}

	public void setUsers(List<Usuarios> users) {
		this.users = users;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Comentario> getComents() {
		return coments;
	}

	public void setComents(List<Comentario> coments) {
		this.coments = coments;
	}
	
	public int getnVotos() {
		return nVotos;
	}

	public void setnVotos(int nVotos) {
		this.nVotos = nVotos;
	}

	public float getVotosTotal() {
		return votosTotal;
	}

	public void setVotosTotal(float votos) {
		this.votosTotal = votos;
	}

	//Metodo para recalcular la valoracion cuando llega un voto nuevo
	public void calcularValoracion (float v) {
		nVotos++;
		votosTotal += v;
		valoracion = votosTotal/nVotos;
		//Truncar
		double scale = Math.pow(10, 1);
	    valoracion = (float) (Math.round((double)valoracion * scale) / scale);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anyo == null) ? 0 : anyo.hashCode());
		result = prime * result + ((coments == null) ? 0 : coments.hashCode());
		result = prime * result + ((compannia == null) ? 0 : compannia.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((juego_estado == null) ? 0 : juego_estado.hashCode());
		result = prime * result + nVotos;
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime * result + ((resumen == null) ? 0 : resumen.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + Float.floatToIntBits(valoracion);
		result = prime * result + Float.floatToIntBits(votosTotal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		if (anyo == null) {
			if (other.anyo != null)
				return false;
		} else if (!anyo.equals(other.anyo))
			return false;
		if (coments == null) {
			if (other.coments != null)
				return false;
		} else if (!coments.equals(other.coments))
			return false;
		if (compannia == null) {
			if (other.compannia != null)
				return false;
		} else if (!compannia.equals(other.compannia))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (juego_estado == null) {
			if (other.juego_estado != null)
				return false;
		} else if (!juego_estado.equals(other.juego_estado))
			return false;
		if (nVotos != other.nVotos)
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		if (resumen == null) {
			if (other.resumen != null)
				return false;
		} else if (!resumen.equals(other.resumen))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (Float.floatToIntBits(valoracion) != Float.floatToIntBits(other.valoracion))
			return false;
		if (Float.floatToIntBits(votosTotal) != Float.floatToIntBits(other.votosTotal))
			return false;
		return true;
	}
	
	
}
