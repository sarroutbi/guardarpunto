package es.sidelab.guardar_punto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoRepository extends JpaRepository<Estado,EstadoId>{
	
	
}
