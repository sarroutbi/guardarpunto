package es.sidelab.guardar_punto;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {
	
	@Autowired
	private UsuariosRepository repositoryUsuario;

	@PostConstruct
	public void init() {
		Usuarios us = new Usuarios();
		us.setId(7);
		us.setNombre("Jimichi");
		repositoryUsuario.save(us);
		
	}

	@GetMapping("/")
	public String Inicio(Model model) {

		return "Inicio";
	}
	
	@GetMapping("/usuario/{id}")
	public String Usuario(Model model,@PathVariable Integer id) {
		Usuarios user = repositoryUsuario.findOne(id);
		
		/*model.addAttribute("nombre",user.getNombre());
		model.addAttribute("biografia",user.getBiografia());
		
		model.addAttribute("listaJugando",user.getJuegos());
		model.addAttribute("listaJugados",user.getJuegos());
		model.addAttribute("listaPendientes",user.getJuegos());
		
		model.addAttribute("listaAmigos",user.getAmigos());
		model.addAttribute("listaComentarios",user.getComents());
		model.addAttribute("listaReviews",user.getReview());
		*/
		return "Usuario";
	}

	
}
