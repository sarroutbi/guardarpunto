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
		Usuarios jm = new Usuarios(1,"Jimichi");
		Usuarios tae = new Usuarios(2, "Tae");
		Usuarios jC = new Usuarios(3, "Jungkook");
		Usuarios rm = new Usuarios(4, "RM");
		Usuarios dvd = new Usuarios(5, "David");
		repositoryUsuario.save(jm);
		repositoryUsuario.save(tae);
		repositoryUsuario.save(jC);
		repositoryUsuario.save(rm);
		repositoryUsuario.save(dvd);
		
		List<Usuarios> amigos = new ArrayList<Usuarios>();
		amigos.add(tae);
		amigos.add(jC);
		amigos.add(rm);
		amigos.add(dvd);
		jm.setUsuarios(amigos);
		jm.setAmigos(amigos);
		
		
		
		
	}

	@GetMapping("/")
	public String Inicio(Model model) {

		return "Inicio";
	}
	
	
	@GetMapping("/Amigos/{id:[\\d]+}")
	public String amigos(Model model,@PathVariable Integer id) {
		//int idUsuario = Integer.parseInt(id);
		Usuarios usuario = repositoryUsuario.findOne(id);
		List<Usuarios> amigos = new ArrayList<Usuarios>(usuario.getAmigos());
		
		model.addAttribute("amigos",amigos);
		
		return "Amigos";
	}
	
	@GetMapping("/Usuario")
	public String usuario(Model model) {
		return "user";
	}
	
	@GetMapping("/Review")
	public String rev(Model model) {
		return "Reviews";
	}
	
	
}
