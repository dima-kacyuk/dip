package game.apeiron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import game.apeiron.models.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>{

}