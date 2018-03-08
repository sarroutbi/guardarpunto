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
	public String amigos(Model model, HttpServletRequest request) {		
		List<Usuarios> amigos = new ArrayList<Usuarios>();
		String displayOff = "none";
		
		if(userComponent.isLoggedUser()) {
			Usuarios loggedUser = userComponent.getLoggedUser();
			System.out.println(loggedUser.getNombre());
			amigos = new ArrayList<Usuarios>(loggedUser.getAmigos());
			displayOff = "block";
		}	
				
	    model.addAttribute("amigos",amigos);
	    model.addAttribute("displayOff", displayOff);
	    
	    CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		model.addAttribute("token", token.getToken());
		
		return "Amigos";
	}
}
