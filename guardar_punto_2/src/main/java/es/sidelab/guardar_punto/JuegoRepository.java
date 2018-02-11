package es.sidelab.guardar_punto;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

	/*Busca el juego en funcion del estado del juego y el id del usuario*/
	@Query(value="SELECT j.id,j.title,j.compannia,j.anyo,j.plataforma,j.valoracion,j.genero,j.resumen,j.imagen"
			+ " FROM Usuarios u,Estado e,Juego j WHERE e.estado=:estat AND u.id=:u_id")
	List<Juego> findByEstadoYUser(@Param("estat") String es,@Param("u_id") Integer us);
	
 }
