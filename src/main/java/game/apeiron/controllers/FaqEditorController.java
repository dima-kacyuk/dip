package game.apeiron.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import game.apeiron.models.Faq;
import game.apeiron.repositories.FaqRepository;

@Controller
public class FaqEditorController {
	@Autowired
	private FaqRepository repo;

	@GetMapping("/faq/editor")
	public String getNews(Model model) {
		model.addAttribute("faqs", repo.findAll());
		model.addAttribute("contentPage", "faqeditor");
		return "main";
	}

	@GetMapping("/faq/delete/{id}")
	private String deleteNews(@PathVariable("id") Integer id) {
		repo.deleteById(id);
		return "redirect:/faq/editor";
	}

	@PostMapping("/faq/add")
	private String addNews(@ModelAttribute("faq") Faq faq) {
		repo.save(faq);
		return "redirect:/faq/editor";
	}

	@GetMapping("/faq/edit{id}")
	private String editNews(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("faq", repo.getOne(id));
		model.addAttribute("contentPage", "faqedit");
		return "main";
	}
}