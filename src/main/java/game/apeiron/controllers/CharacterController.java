package game.apeiron.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import game.apeiron.models.User;
import game.apeiron.repositories.UserRepository;
import game.apeiron.models.Character;

@RestController
public class CharacterController {
	@Autowired
	private UserRepository userRepo;

	@CrossOrigin(origins = "http://localhost:50000")
	@GetMapping("/game/getCharacter")
	public Character getCharacter() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String login;
		if (principal instanceof UserDetails) {
			login = ((UserDetails) principal).getUsername();
		} else {
			login = principal.toString();
		}

		User user = userRepo.findByLogin(login).get();
		Character character = new Character(user);

		return character;
	}
}