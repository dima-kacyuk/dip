package game.apeiron.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import game.apeiron.models.User;
import game.apeiron.repositories.UserRepository;

@Controller
public class ProfileController {
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/profile")
	private String getProfile(Model model, Principal principal) {
		String login = principal.getName();

		model.addAttribute("user", userRepo.findByLogin(login).get());
		model.addAttribute("contentPage", "profile");
		return "main";
	}

	@PostMapping("/profile/edit")
	private String editProfile(@ModelAttribute("user") User user, Principal principal) {
		String login = principal.getName();

		user.setRoles(userRepo.findByLogin(login).get().getRoles());
		userRepo.save(user);
		return "redirect:/profile";
	}
}
