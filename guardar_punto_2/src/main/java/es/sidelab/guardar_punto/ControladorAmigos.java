package es.sidelab.guardar_punto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorAmigos {
	
	@Autowired
	private UsuariosRepository repositoryUsuario;
	
	
	@GetMapping("/Amigos/{id}")
	public String amigos(Model model,@PathVariable String id) {
		//int idUsuario = Integer.parseInt(id);
		int num = Integer.parseInt(id);
		Usuarios usuario = repositoryUsuario.findOne(num);
		List<Usuarios> amigos = new ArrayList<Usuarios>(usuario.getAmigos());
		
	    model.addAttribute("amigos",amigos);
		
		return "Amigos";
	}
}
