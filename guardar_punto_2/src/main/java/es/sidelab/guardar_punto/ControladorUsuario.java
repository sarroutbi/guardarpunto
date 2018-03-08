package es.sidelab.guardar_punto;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorUsuario {
	@Autowired
	private EstadoRepository repositoryEstados;
	@Autowired
	private UsuariosRepository repositoryUsuario;
	@Autowired
	private ComentariosRepository repositoryComentarios;
	@Autowired
	private ReviewRepository repositoryReviews;
	//Obtener usuario logueado
	@Autowired
	private UserComponent userComponent;

	//Ver el perfil de un usuario cualquiera
	@GetMapping("/Usuario/{id}")
	public String usuario(Model model,@PathVariable String id, HttpServletRequest request) {
		String displayEditar = "none";
		int num = Integer.parseInt(id);
		Usuarios usuario = repositoryUsuario.findOne(num);
		String displayOff = "none";
		
		if(userComponent.isLoggedUser()) {
			displayOff = "block";
		}
		model.addAttribute("displayOff", displayOff);
		
		return datosUsuario(model, usuario, request, displayEditar);		
	}
	
	//Ver el perfil del usuario logueado
	@GetMapping("/Perfil")
	public String usuario(Model model, HttpServletRequest request) {
		if(userComponent.isLoggedUser()) {
			Usuarios loggedUser = userComponent.getLoggedUser();	
			String displayEditar = "block";
			String displayOff = "block";
			model.addAttribute("displayOff", displayOff);
			return datosUsuario(model, loggedUser, request, displayEditar);
		} else {
			return "Not logged";
		}
		
	}
	
	//Pone en el modelo los datos del usuario que recibe como argumento
	private String datosUsuario (Model model, Usuarios usuario, HttpServletRequest request, String displayEditar) {
		String name = usuario.getNombre();
		String bio = usuario.getBiografia();
		String imagen = usuario.getImagen();
		List<Usuarios> amigos = new ArrayList<Usuarios>(usuario.getAmigos());
		
		
		List<Juego> jugados = new ArrayList<Juego>(repositoryEstados.findByStateAndEstadouser("jugado", usuario));
		List<Juego> jugando = new ArrayList<Juego>(repositoryEstados.findByStateAndEstadouser("jugando", usuario));
		List<Juego> pendientes = new ArrayList<Juego>(repositoryEstados.findByStateAndEstadouser("pendiente", usuario));			
		
		//List<Comentario> comentarios = new ArrayList<Comentario>(usuario.getComents());
		List<Comentario> comentarios = new ArrayList<Comentario>(repositoryComentarios.findByUser(usuario));
		List<Review> reviews = new ArrayList<Review>(repositoryReviews.findByUser(usuario));
		
		model.addAttribute("id",usuario.getId());
		model.addAttribute("imagen",imagen);
		model.addAttribute("nombre",name);
		model.addAttribute("biografia", bio);
		model.addAttribute("listaAmigos",amigos);
		model.addAttribute("listaJugados",jugados);
		model.addAttribute("listaJugando",jugando);
		model.addAttribute("listaPendientes",pendientes);
		model.addAttribute("listaComentarios",comentarios);
		model.addAttribute("listaReviews",reviews);
		model.addAttribute("displayEditar", displayEditar);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		model.addAttribute("token", token.getToken());
		
		return "Usuario";
	}
	
	//Cambios en el usuario
	@PostMapping("/editarUsuario")
	public String editarUsuario (Model model,Usuarios usuario, HttpServletRequest request) {
			Integer idAux = usuario.getId();
			String bioAux = usuario.getBiografia();
			String imagenAux = usuario.getImagen();

			Usuarios user = repositoryUsuario.findOne(idAux);
			if(!bioAux.isEmpty()) {
				user.setBiografia(bioAux);
			}
			if(!imagenAux.isEmpty()) {
				user.setImagen(imagenAux);
			}
			repositoryUsuario.save(user);
			usuario(model,usuario.getId().toString(), request);
			return "Usuario";
	}
}
