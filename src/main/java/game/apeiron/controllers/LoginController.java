package game.apeiron.controllers;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@PostMapping(value = "/login")
	public String Login(@RequestParam Optional<String> error, Model model) {
		model.addAttribute("error", error);
		return "login";
	}

	@GetMapping(value = "/login")
	public String getLoginPage(@RequestParam Optional<String> error, Model model) {
		model.addAttribute("error", error);
		return "login";
	}
}