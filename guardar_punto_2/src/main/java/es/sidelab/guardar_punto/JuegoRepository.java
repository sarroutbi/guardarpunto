package es.sidelab.guardar_punto;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego,Integer> {
	List<Juego> findByTitle(String Titulo);
	List<Juego> findByCompannia(String Compannia);
	List<Juego> findByAnyo(String anyo);
	List<Juego> findByPlataforma(String Plataforma);
	List<Juego> findByGenero(String Genero);
	
	//Buscar todos los juegos cuyo titulo empiece por cierta letra
	List<Juego> findByTitleIgnoreCaseStartingWith (String letra);
	//Buscar juegos cuyo titulo contenga la palabra introducida en la busqueda
	List<Juego> findByTitleIgnoreCaseLike (String title);
 }
