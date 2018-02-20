package es.sidelab.guardar_punto;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorFichaJuego {

	//Repositorios
	@Autowired
	private UsuariosRepository repositoryUsuario;	
	@Autowired
	private JuegoRepository repositoryJuego;
	@Autowired
	private ReviewRepository repositoryReview;
	@Autowired
	private ComentariosRepository repositoryComentario;
	@Autowired
	private EstadoRepository repositoryEstados;
	
	//Ficha del juego indicado en el enlace
	@GetMapping("/juego/{id}")
	public String fichaJuego (Model model, @PathVariable String id) {		
		int numero = Integer.parseInt(id);
		//Buscarlo en la bd por el id
		Juego juego = repositoryJuego.findOne(numero); 
		//Añadir al model el juego, su lista de reviews y su lista de comentarios		
		model.addAttribute("juego", juego);
		model.addAttribute("listaReviews", juego.getReviews());
		model.addAttribute("listaComentarios", juego.getComents());
		
		return "FichaJuego";
	}
	
	//Añadir nuevo comentario a un juego. De momento, vienen todos del mismo usuario.
	@PostMapping("/nuevoComentario")
	public String nuevoComentario (Model model, Comentario comentario) {
		Integer idUsuario = Integer.parseInt(comentario.getId_usuario());
		Integer idJuego = Integer.parseInt(comentario.getId_juego());
		//Asignar el usuario (siempre el 1 de momento) y el juego
		comentario.setUser(repositoryUsuario.findOne(idUsuario));
		comentario.setJuego(repositoryJuego.findOne(idJuego));
		//Guardar nuevo comentario en el repositorio
		repositoryComentario.save(comentario);
		
		//Volver a cargar la pagina del juego		
		fichaJuego (model, comentario.getJuego().getId().toString());
		return "FichaJuego";
	}
	
	//Añadir nueva review a un juego. De momento, vienen todos del mismo usuario.
	@PostMapping("/nuevaReview")
	public String nuevaReview (Model model, Review review) {
		Integer idUsuario = Integer.parseInt(review.getId_usuario());
		Integer idJuego = Integer.parseInt(review.getId_juego());
		//Asignar el usuario (siempre el 1 de momento) y el juego
		review.setUser(repositoryUsuario.findOne(idUsuario));
		review.setJuego(repositoryJuego.findOne(idJuego));
		//Asignar primera linea		
		review.setPrimeraLinea(review.getTexto().substring(0, 10));
		//Guardar nueva review en el repositorio
		repositoryReview.save(review);
		
		//Actualizar puntuacion del juego y volverlo a guardar en la db
		repositoryJuego.findOne(idJuego).calcularValoracion(review.getPuntuacion());	
		repositoryJuego.save(repositoryJuego.findOne(idJuego));
		
		//Volver a cargar la pagina del juego		
		fichaJuego (model, review.getJuego().getId().toString());
		return "FichaJuego";
	}
	
	//Añadir un juego a la lista (de momento se añade siempre al jugador 1)
	@GetMapping("/anadirLista/{estado}/{id_juego}/{id_usuario}")
	public String anadirLista(Model model,@PathVariable String estado, @PathVariable String id_juego, @PathVariable String id_usuario) {
		
		//Este if es para evitar errores cuando carga el css y el js
		if(!id_juego.equals("js") && !id_juego.equals("css") && !id_usuario.equals("js") && !id_usuario.equals("css")) {
			//Obtener juego de la bd
			int numeroj = Integer.parseInt(id_juego);		
			Juego juego = repositoryJuego.findOne(numeroj);
			//Obtener usuario de la bd
			int numerou = Integer.parseInt(id_usuario);		
			Usuarios usuario = repositoryUsuario.findOne(numerou);
			
			//Comprobar si el usuario tiene ya este juego en alguna lista
			Estado state = repositoryEstados.findByJuegosestadoeAndEstadouser(juego, usuario);
			if(state == null) {
				//No esta en ninguna lista, hay que añadirlo al repositorio
				List<Estado> estadosUsuario = new ArrayList<Estado>();
				Estado e = new Estado(usuario, juego, estado);			
				repositoryEstados.save(e);			
				estadosUsuario.add(e);
				usuario.setEstados(estadosUsuario);
				repositoryUsuario.save(usuario);		
			} else {
				//Ya esta en alguna de las listas, hay que cambiar su estado
				repositoryEstados.updateEstado(estado, usuario, juego);
			}
			return fichaJuego (model, juego.getId().toString());
		}	
		
		return null;
	}
}
