package es.sidelab.guardar_punto;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByUser(Usuarios user);
	List<Review> findByJuego(Juego juego);
}
