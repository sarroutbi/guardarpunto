package es.sidelab.guardar_punto;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@CacheConfig(cacheNames="usuarios")
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	@CacheEvict(allEntries=true)
	Review save(Review review);
	
	@Cacheable
	List<Review> findByUser(Usuarios user);
	@Cacheable
	List<Review> findByJuego(Juego juego);
}
