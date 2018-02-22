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
	
	@GetMapping("/Review/{id}")
	public String rev(Model model,@PathVariable String id) {
		int num = Integer.parseInt(id);
		Usuarios usuario = repositoryUsuario.findOne(num);
		List<Review> reviews = new ArrayList<Review>(usuario.getReview());
		
		model.addAttribute("listaReviews",reviews);
		return "Reviews";
	}
}
