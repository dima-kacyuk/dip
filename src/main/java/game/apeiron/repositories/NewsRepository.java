package game.apeiron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import game.apeiron.models.New;

@Repository
public interface NewsRepository extends JpaRepository<New, Integer> {

}
