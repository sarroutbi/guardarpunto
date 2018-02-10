package es.sidelab.guardar_punto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosRepository extends JpaRepository<Comentario,Integer> {
	List<Comentario> findByUser(Usuarios user);
	List<Comentario> findByJuego(Juego juego);
	
 }
