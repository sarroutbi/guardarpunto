package es.sidelab.guardar_punto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorReview {
	@Autowired
	private UsuariosRepository repositoryUsuario;
	
	//Obtener usuario logueado
	@Autowired
	private UserComponent userComponent;
	
	//Obtener lista de reviews de usuario logueado
	//Si no esta logueado, como la pagina es privada, redirige al inicio
	@GetMapping("/Review")
	public String rev(Model model) {		
		List<Review> reviews = new ArrayList<Review>();
		
		if(userComponent.isLoggedUser()) {
			Usuarios loggedUser = userComponent.getLoggedUser();	
			reviews = new ArrayList<Review>(loggedUser.getReview());
		}
		
		model.addAttribute("listaReviews",reviews);
		return "Reviews";
	}
}
