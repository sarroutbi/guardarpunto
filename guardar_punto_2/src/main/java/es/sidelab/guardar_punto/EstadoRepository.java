package es.sidelab.guardar_punto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado,EstadoId>{
	
	@Query(value="SELECT e.estado_user, e.juegos_estado FROM Estado e WHERE e.estado_user=:user AND e.juegos_estado=:juego")
	List<Estado> findByUsuariosyJuego(@Param("user") Integer u_id, @Param("juego") Integer j_id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE Estado e SET estado=:es WHERE e.estado_user=:uid AND e.juegos_estado=:jogo")
	List<Estado> updateEstado(@Param("es") String es, @Param("uid") Usuarios u_id, @Param("jogo") Juego j_id);
	
}
