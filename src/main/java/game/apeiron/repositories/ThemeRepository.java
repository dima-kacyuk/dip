package game.apeiron.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import game.apeiron.models.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {
	@Query(value = "SELECT * FROM FORUM WHERE author = ?1 ORDER BY date DESC", nativeQuery = true)
	List<Theme> findByAuthor(long id);

	@Query(value = "SELECT * FROM FORUM ORDER BY date DESC", nativeQuery = true)
	List<Theme> findAll();
}