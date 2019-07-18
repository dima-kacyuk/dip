package game.apeiron.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import game.apeiron.models.New;
import game.apeiron.repositories.NewsRepository;

@Controller
public class NewsController {
	@Autowired
	private NewsRepository repo;

	@GetMapping("/news")
	public String getNews(Model model) {

		List<New> sorted = repo.findAll().stream().sorted(Comparator.comparing(New::getDate).reversed())
				.collect(Collectors.toList());

		model.addAttribute("news", sorted);
		model.addAttribute("contentPage", "news");
		return "main";
	}
}