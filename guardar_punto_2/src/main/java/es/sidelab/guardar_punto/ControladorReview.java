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
public class ControladorReview {
	@Autowired
	private UsuariosRepository repositoryUsuario;
	@Autowired
	private ReviewRepository repositoryReviews;
	
	//Obtener usuario logueado
	@Autowired
	private UserComponent userComponent;
	
	//Obtener lista de reviews de usuario logueado
	//Si no esta logueado, como la pagina es privada, redirige al inicio
	@GetMapping("/Reviews")
	public String rev(Model model, HttpServletRequest request) {	
		System.out.println("qaaaaaaaa");
		List<Review> reviews = new ArrayList<Review>();
		String displayOff = "none";
		
		if(userComponent.isLoggedUser()) {
			Usuarios loggedUser = userComponent.getLoggedUser();
			reviews = new ArrayList<Review>(repositoryReviews.findByUser(loggedUser));
			displayOff = "block";
		}
		
		model.addAttribute("listaReviews",reviews);
		model.addAttribute("displayOff", displayOff);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		model.addAttribute("token", token.getToken());
		
		return "Reviews";
	}
}
