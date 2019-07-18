package game.apeiron.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import game.apeiron.models.Role;
import game.apeiron.models.User;
import game.apeiron.repositories.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository repo;

	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute("users", repo.findAll());
		model.addAttribute("contentPage", "users");
		return "main";
	}

	@GetMapping("/ban{id}")
	public String banUser(@PathVariable("id") long id, Model model) {
		User user = repo.getOne(id);
		Collection<Role> roles = user.getRoles();
		roles.add(Role.BANNED);
		user.setRoles(roles);
		repo.save(user);
		return "redirect:/users";
	}

	@GetMapping("/unban{id}")
	public String unBanUser(@PathVariable("id") long id, Model model) {
		User user = repo.getOne(id);
		Collection<Role> roles = user.getRoles();
		roles.remove(Role.BANNED);
		user.setRoles(roles);
		repo.save(user);
		return "redirect:/users";
	}
}