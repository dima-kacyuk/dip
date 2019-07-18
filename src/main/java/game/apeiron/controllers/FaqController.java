package game.apeiron.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import game.apeiron.repositories.FaqRepository;

@Controller
public class FaqController {

	@Autowired
	private FaqRepository repo;

	@GetMapping("/faq")
	public String getNews(Model model) {
		model.addAttribute("faqs", repo.findAll());
		model.addAttribute("contentPage", "faq");
		return "main";
	}
}
