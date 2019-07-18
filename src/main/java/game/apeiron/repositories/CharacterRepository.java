package game.apeiron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import game.apeiron.models.Faq;

@Repository
public interface CharacterRepository extends JpaRepository<Faq, Integer> {
	/* public Optional<Character> findByUser(User user); */
}