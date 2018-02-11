package es.sidelab.guardar_punto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado,EstadoId>{
	
	@Query(value="SELECT e.estadouser, e.juegosestado FROM Estado e WHERE e.estadouser=:user AND e.juegosestado=:juego")
	List<Estado> findByUsuariosyJuego(@Param("user") Integer u_id, @Param("juego") Integer j_id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Estado e SET state=:es WHERE e.estadouser=:uid AND e.juegosestado=:jogo")
	void updateEstado(@Param("es") String es, @Param("uid") Usuarios u_id, @Param("jogo") Juego j_id);
		
	@Query("select t from Estado t where t.state = ?1")
	List<Estado> findByStateIgnoreCaseLike (String state);
	@Query("select t from Estado t where t.estadouser = ?1")
	List<Estado> findByEstadouser (Usuarios estadouser);
	//Buscar juegos por estado e id usuario
	@Query("select t.juegosestado from Estado t where t.state = ?1 and t.estadouser = ?2")
	List<Juego> findByStateAndEstadouser (String estado, Usuarios estadouser);
	//Buscar estado por juego y usuario
	@Query("select t from Estado t where t.juegosestado = ?1 and t.estadouser = ?2")
	Estado findByJuegosestadoeAndEstadouser (Juego juegosestado, Usuarios estadouser);
	
}
