package es.sidelab.guardar_punto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {
	


	public Controlador() {
		
	}

	@RequestMapping("/")
	public String Inicio(Model model, Pageable page) {

		

		return "Inicio";
	}
}
