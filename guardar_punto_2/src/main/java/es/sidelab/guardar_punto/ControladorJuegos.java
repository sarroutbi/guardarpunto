package es.sidelab.guardar_punto;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorJuegos {
	
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
	
		//Lista de TODOS los juegos que hay en la BD, divididos por la letra inicial
		@GetMapping("/Juegos") 
		public String Juegos (Model model, HttpServletRequest request) {
			model.addAttribute("listaJuegosA", repositoryJuego.findByTitleIgnoreCaseStartingWith("A"));
			model.addAttribute("listaJuegosB", repositoryJuego.findByTitleIgnoreCaseStartingWith("B"));
			model.addAttribute("listaJuegosC", repositoryJuego.findByTitleIgnoreCaseStartingWith("C"));
			model.addAttribute("listaJuegosD", repositoryJuego.findByTitleIgnoreCaseStartingWith("D"));
			model.addAttribute("listaJuegosE", repositoryJuego.findByTitleIgnoreCaseStartingWith("E"));
			model.addAttribute("listaJuegosF", repositoryJuego.findByTitleIgnoreCaseStartingWith("F"));
			model.addAttribute("listaJuegosG", repositoryJuego.findByTitleIgnoreCaseStartingWith("G"));
			model.addAttribute("listaJuegosH", repositoryJuego.findByTitleIgnoreCaseStartingWith("H"));
			model.addAttribute("listaJuegosI", repositoryJuego.findByTitleIgnoreCaseStartingWith("I"));
			model.addAttribute("listaJuegosJ", repositoryJuego.findByTitleIgnoreCaseStartingWith("J"));
			model.addAttribute("listaJuegosK", repositoryJuego.findByTitleIgnoreCaseStartingWith("K"));
			model.addAttribute("listaJuegosL", repositoryJuego.findByTitleIgnoreCaseStartingWith("L"));
			model.addAttribute("listaJuegosM", repositoryJuego.findByTitleIgnoreCaseStartingWith("M"));
			model.addAttribute("listaJuegosN", repositoryJuego.findByTitleIgnoreCaseStartingWith("N"));
			model.addAttribute("listaJuegosO", repositoryJuego.findByTitleIgnoreCaseStartingWith("O"));
			model.addAttribute("listaJuegosP", repositoryJuego.findByTitleIgnoreCaseStartingWith("P"));
			model.addAttribute("listaJuegosQ", repositoryJuego.findByTitleIgnoreCaseStartingWith("Q"));
			model.addAttribute("listaJuegosR", repositoryJuego.findByTitleIgnoreCaseStartingWith("R"));
			model.addAttribute("listaJuegosS", repositoryJuego.findByTitleIgnoreCaseStartingWith("S"));
			model.addAttribute("listaJuegosT", repositoryJuego.findByTitleIgnoreCaseStartingWith("T"));
			model.addAttribute("listaJuegosU", repositoryJuego.findByTitleIgnoreCaseStartingWith("U"));
			model.addAttribute("listaJuegosV", repositoryJuego.findByTitleIgnoreCaseStartingWith("V"));
			model.addAttribute("listaJuegosW", repositoryJuego.findByTitleIgnoreCaseStartingWith("W"));
			model.addAttribute("listaJuegosX", repositoryJuego.findByTitleIgnoreCaseStartingWith("X"));
			model.addAttribute("listaJuegosY", repositoryJuego.findByTitleIgnoreCaseStartingWith("Y"));
			model.addAttribute("listaJuegosZ", repositoryJuego.findByTitleIgnoreCaseStartingWith("Z"));
			
			//En el panel "tus juegos" aparecen los juegos jugados del usuario que ha iniciado sesion
			//En la fase 2 fingimos que ha iniciado sesion el usuario 1
			List<Juego> jugados = new ArrayList<Juego>(repositoryEstados.findByStateAndEstadouser(
					"jugado", repositoryUsuario.findOne(1)));
			model.addAttribute("listaJuegosUsuario", jugados);
			
		    CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
			model.addAttribute("token", token.getToken());
			
			return "Juegos";
		}
		
		//Pagina que muestra los resultados de la busqueda (juegos o usuarios)
		@PostMapping("/buscar")
		public String Busqueda (Model model, String txt, HttpServletRequest request) {
			System.out.println("Busqueda");
			model.addAttribute("listaJuegosEncontrados", repositoryJuego.findByTitleIgnoreCaseLike("%"+txt+"%"));
			model.addAttribute("listaUsuariosEncontrados", repositoryUsuario.findByNombreIgnoreCaseLike("%"+txt+"%"));
			
		    CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
			model.addAttribute("token", token.getToken());
			
			return "Busqueda";
		}

}
