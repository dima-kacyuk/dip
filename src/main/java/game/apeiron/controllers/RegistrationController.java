package game.apeiron.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import game.apeiron.models.Role;
import game.apeiron.models.User;
import game.apeiron.repositories.UserRepository;

@Controller
public class RegistrationController {
	@Autowired
	private UserRepository userRepo;

	@GetMapping(value = "/registration")
	public String getRegistrationPage() {
		return "registration";
	}

	@PostMapping(value = "/registration")
	private String addUser(@ModelAttribute User user) {
		boolean isEmpty = !userRepo.findByLogin(user.getLogin()).isPresent();

		if (isEmpty) {
			List<Role> roles = Arrays.asList(new Role[] { Role.USER });
			user.setRoles(roles);
			user.setRating(0);
			userRepo.saveAndFlush(user);
			return "redirect:/login";
		}

		return "registration";
	}
}