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
	
	//Repositorios
	@Autowired
	private UsuariosRepository repositoryUsuario;	
	@Autowired
	private JuegoRepository repositoryJuego;
	@Autowired
	private ReviewRepository repositoryReview;
	@Autowired
	private ComentariosRepository repositoryComentario;

	
	@PostConstruct
	public void init() {
		
		/*** AÑADIR DATOS A LA BD ***/
		//USUARIOS
		Usuarios marta = new Usuarios (1,"Marta", "marta@gmail.com", "martapass", "Bio de Marta");
		Usuarios susi = new Usuarios (2,"Susi", "susi@gmail.com", "susipass", "Bio de Susi");
		Usuarios adri = new Usuarios (3,"Adri", "adria@gmail.com", "adripass", "Bio de Adri");
		Usuarios sergio = new Usuarios (4,"Sergio", "sergio@gmail.com", "sergiopass", "Bio de Sergio");
		Usuarios guille = new Usuarios (5,"Guille", "guille@gmail.com", "guillepass", "Bio de Guille");
		Usuarios agus = new Usuarios (6,"Agus", "agus@gmail.com", "aguspass", "Bio de Agus");
		
		repositoryUsuario.save(marta);
		repositoryUsuario.save(susi);
		repositoryUsuario.save(adri);
		repositoryUsuario.save(sergio);
		repositoryUsuario.save(guille);
		repositoryUsuario.save(agus);
		
		//AMIGOS - esto no lo pillo 		
		
		//JUEGOS
		Juego portal = new Juego ("Portal", "Valve", "2007", "PC", 0.0f, "Puzles", "Resumen de Portal");
		Juego horizon = new Juego ("Horizon Zero Dawn", "Guerrilla Games", "2017", "PS4", 0.0f, "Aventura", "Resumen de Horizon Zero Dawn");
		Juego pkmnLuna = new Juego ("Pokémon Luna","Nintendo", "2017", "3DS", 0.0f, "RPG", "Resumen de Pokémon Luna");
		Juego aa1 = new Juego ("Ace Atorney", "Capcom", "2005", "DS", 0.0f, "Novela Visual", "Resumen de Ace Attorney");
		Juego wow = new Juego ("World of Warcraft", "Blizzard", "2004", "PC", 0.0f, "MMORPG", "Resumen de World of Warcraft");
		Juego civilization6 = new Juego ("Civilization VI", "2k Games", "2016", "PC", 0.0f, "Estrategia", "Resumen de Portal");
		//pls añadan alguno mas 
	
		repositoryJuego.save(portal);
		repositoryJuego.save(horizon);
		repositoryJuego.save(pkmnLuna);
		repositoryJuego.save(aa1);
		repositoryJuego.save(wow);
		repositoryJuego.save(civilization6);
		
		//REVIEWS
		Review rPortalMarta = new Review ("Review de Portal por Marta", 5.0f);
		rPortalMarta.setJuego(portal); rPortalMarta.setUser(marta);
		repositoryReview.save(rPortalMarta);
		
		Review rPortalAdri = new Review ("Review de Portal por Adri", 4.0f);
		rPortalAdri.setJuego(portal); rPortalAdri.setUser(adri);
		repositoryReview.save(rPortalAdri);
		
		Review rWowSusi = new Review ("Review de World of Warcraft por Susi", 5.0f);
		rWowSusi.setJuego(wow); rWowSusi.setUser(susi);
		repositoryReview.save(rWowSusi);
		
		Review rWowGuille = new Review ("Review de World of Warcraft por Guille", 2.5f);
		rWowGuille.setJuego(wow); rWowGuille.setUser(guille);
		repositoryReview.save(rWowGuille);
		
		Review rHorizonAgus = new Review ("Review de Horizon Zero Dawn por Agus", 4.7f);
		rHorizonAgus.setJuego(horizon); rHorizonAgus.setUser(agus);
		repositoryReview.save(rHorizonAgus);
		
		Review rHorizonSergio = new Review ("Review de Horizon Zero Dawn por Sergio", 3.2f);
		rHorizonSergio.setJuego(horizon); rHorizonSergio.setUser(sergio);
		repositoryReview.save(rHorizonSergio);
		
		//COMENTARIOS
		Comentario rAAMarta = new Comentario ("Comentario de Ace Attorney por Marta");
		rAAMarta.setJuego(aa1); rAAMarta.setUser(marta);
		repositoryComentario.save(rAAMarta);
		
		Comentario rAAAdri = new Comentario ("Comentario de Ace Attorney por Adri");
		rAAAdri.setJuego(aa1); rAAAdri.setUser(adri);
		repositoryComentario.save(rAAAdri);
		
		Comentario rCiviSusi = new Comentario ("Comentario de Civilization por Susi");
		rCiviSusi.setJuego(civilization6); rCiviSusi.setUser(susi);
		repositoryComentario.save(rCiviSusi);
		
		Comentario rCiviGuille = new Comentario ("Comentario de Civilization por Guille");
		rCiviGuille.setJuego(civilization6); rCiviGuille.setUser(guille);
		repositoryComentario.save(rCiviGuille);
		
		Comentario rLunaAgus = new Comentario ("Comentario de Pokémon Luna por Agus");
		rLunaAgus.setJuego(pkmnLuna); rLunaAgus.setUser(agus);
		repositoryComentario.save(rLunaAgus);
		
		Comentario rLunaSergio = new Comentario ("Comentario de Pokémon Luna por Sergio");
		rLunaSergio.setJuego(pkmnLuna); rLunaSergio.setUser(sergio);
		repositoryComentario.save(rLunaSergio);
		
		
		/*
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
		amigos.add(dvd);*/
		//jm.setUsuarios(amigos);
		//jm.setAmigos(amigos);
	}

	@GetMapping("/")
	public String Inicio(Model model) {

		return "Inicio";
	}
	
	
	@GetMapping("/Amigos/{id:[\\d]+}")
	public String amigos(Model model,@PathVariable Integer id) {
		//int idUsuario = Integer.parseInt(id);
		Usuarios usuario = repositoryUsuario.findOne(id);
		//List<Usuarios> amigos = new ArrayList<Usuarios>(usuario.getAmigos());
		
		//model.addAttribute("amigos",amigos);
		
		return "Amigos";
	}
	
	@GetMapping("/Usuario")
	public String usuario(Model model) {
		model.addAttribute("nombre","Jimichi");
		model.addAttribute("biografia", "biografia de Jimichi");
		return "Usuario";
	}
	
	@GetMapping("/Review")
	public String rev(Model model) {
		return "Reviews";
	}
	
	
}
