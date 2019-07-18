package game.apeiron.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
	@GetMapping("/game")
	private String getIndex(Model model) {
		model.addAttribute("contentPage","index");
		return "main";
	}
}