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
	
	/*Busca el juego en funcion del estado del juego y el id del usuario*/
	@Query(value="SELECT j FROM Usuarios u,Estado e,Juego j WHERE e.estado=:estat AND u.id=:u_id")
	List<Juego> findByEstadoYUser(@Param("estat") String es,@Param("u_id") Integer us);
 }
