package game.apeiron.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import game.apeiron.models.New;
import game.apeiron.repositories.NewsRepository;

@Controller
public class NewsEditorController {
	@Autowired
	private NewsRepository repo;

	@GetMapping("/news/editor")
	public String getNews(Model model) {
		model.addAttribute("news", repo.findAll());
		model.addAttribute("contentPage", "newseditor");
		return "main";
	}

	@GetMapping("/news/delete/{id}")
	private String deleteNews(@PathVariable("id") Integer id) {
		repo.deleteById(id);
		return "redirect:/news/editor";
	}

	@GetMapping("/news/edit{id}")
	private String editNews(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("news", repo.getOne(id));
		model.addAttribute("contentPage", "newsedit");
		return "main";
	}

	@PostMapping("/news/add")
	private String addNews(@ModelAttribute("news") New news) {
		if (news.getDate() != null) {
			repo.save(news);
		} else {
			news.setDate(Calendar.getInstance().getTime());
			repo.save(news);
		}
		return "redirect:/news/editor";
	}
}