package game.apeiron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import game.apeiron.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}