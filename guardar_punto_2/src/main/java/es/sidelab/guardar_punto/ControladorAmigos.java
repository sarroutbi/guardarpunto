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
	
	//Obtener usuario logueado
	@Autowired
	private UserComponent userComponent;
	
	//Obtener lista de amigos de usuario logueado
	//Si no esta logueado, como la pagina es privada, redirige al inicio
	@GetMapping("/Amigos")
	public String amigos(Model model) {		
		List<Usuarios> amigos = new ArrayList<Usuarios>();
		
		if(userComponent.isLoggedUser()) {
			Usuarios loggedUser = userComponent.getLoggedUser();
			System.out.println(loggedUser.getNombre());
			amigos = new ArrayList<Usuarios>(loggedUser.getAmigos());
		}	
				
	    model.addAttribute("amigos",amigos);
		
		return "Amigos";
	}
}
