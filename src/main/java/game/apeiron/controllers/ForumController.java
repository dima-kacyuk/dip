package game.apeiron.controllers;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import game.apeiron.models.Theme;
import game.apeiron.repositories.ThemeRepository;
import game.apeiron.repositories.UserRepository;

@Controller
public class ForumController {
	@Autowired
	private ThemeRepository themeRepo;
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/forum")
	public String getForum(Model model) {
		List<Theme> sorted = themeRepo.findAll();

		model.addAttribute("forum", sorted);
		model.addAttribute("contentPage", "forum");
		return "main";
	}

	@GetMapping("/forum/showTheme/{id}")
	private String showTheme(@PathVariable("id") Integer id, Model model) {
		Theme theme = themeRepo.getOne(id);

		model.addAttribute("theme", theme);
		model.addAttribute("messages", theme.getMessages());
		model.addAttribute("contentPage", "showTheme");
		return "main";
	}

	@GetMapping("/forum/addTheme")
	public String getViewAddForumTheme(Model model) {
		model.addAttribute("contentPage", "addTheme");
		return "main";
	}

	@GetMapping("/forum/showMyThemes/{login}")
	private String showMyThemes(@PathVariable("login") String login, Model model) {
		List<Theme> themes = themeRepo.findByAuthor(userRepo.findByLogin(login).get().getId());

		model.addAttribute("themes", themes);
		model.addAttribute("contentPage", "showMyThemes");
		return "main";
	}

	@PostMapping("/forum/addTheme")
	private String addTheme(String name, String description, String login) {
		Theme forum = new Theme(name, description, userRepo.findByLogin(login).get());

		forum.setDate(Calendar.getInstance().getTime());
		themeRepo.saveAndFlush(forum);

		return "redirect:/forum";
	}

	@PostMapping("/forum/addEditedTheme/{id}")
	private String addEditedTheme(@PathVariable("id") Integer id, String name, String description) {

		Theme theme = themeRepo.getOne(id);

		theme.setContent(name, description);
		
		themeRepo.saveAndFlush(theme);

		return "redirect:/forum";
	}
	
	@GetMapping("/forum/editTheme/{id}")
	private String editTheme(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("forum", themeRepo.getOne(id));
		model.addAttribute("contentPage", "editTheme");
		return "main";
	}

	@GetMapping("/forum/deleteTheme/{login}/{id}")
	private String deleteTheme(@PathVariable("login") String login, @PathVariable("id") Integer id) {
		
		themeRepo.delete(themeRepo.getOne(id));
		return "redirect:/forum/showMyThemes/{login}";
	}
	
	@GetMapping("/forum/deleteThemeForAdmin/{id}")
	private String deleteThemeForAdmin(@PathVariable("id") Integer id) {
		
		themeRepo.delete(themeRepo.getOne(id));
		return "redirect:/forum/editor";
	}

	
	@GetMapping("/forum/editor")
	private String forumEditor(Model model) {
		model.addAttribute("themes", themeRepo.findAll());
		model.addAttribute("contentPage", "forumeditor");
		return "main";
	}
}