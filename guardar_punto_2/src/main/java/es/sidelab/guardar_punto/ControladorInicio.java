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
public class ControladorInicio {

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
	
	//Listas auxiliares
	//Lista de juegos destacados que se van a mostrar en la pagina de inicio
	private List<Juego> listaJuegosDestacados = new ArrayList<Juego>();
	
	@PostConstruct
	public void init() {
		/*** Listas auxiliares ***/
		listaJuegosDestacados.add(repositoryJuego.findOne(1));
		listaJuegosDestacados.add(repositoryJuego.findOne(2));
		listaJuegosDestacados.add(repositoryJuego.findOne(6));		
		listaJuegosDestacados.add(repositoryJuego.findOne(7));
	}
	
	//Pagina inicial. 
	//Muestra algunos juegos destacados, almacenados previamente en una lista	
	@GetMapping("/")
	public String Inicio(Model model) {
		model.addAttribute("listaJuegosDestacados", listaJuegosDestacados);
		//En el panel "tus juegos" aparecen los juegos jugados del usuario que ha iniciado sesion
		//En la fase 2 fingimos que ha iniciado sesion el usuario 1
		List<Juego> jugados = new ArrayList<Juego>(repositoryEstados.findByStateAndEstadouser(
				"jugado", repositoryUsuario.findOne(1)));
		model.addAttribute("listaJuegosUsuario", jugados);
		
		return "Inicio";
	}
	
	//Registrar nuevo usuario
	@PostMapping("/nuevoUsuario")
	public String nuevoUsuario (Model model, Usuarios usuario) {
		//Guardar el nuevo usuario en la db
		repositoryUsuario.save(usuario);
		Inicio(model);
		return "Inicio";
	}
}
