package es.sidelab.guardar_punto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios,Integer> {
	List<Usuarios> findByNombre(String nombre);
}

