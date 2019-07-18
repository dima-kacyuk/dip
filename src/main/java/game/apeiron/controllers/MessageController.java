package game.apeiron.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import game.apeiron.models.Message;
import game.apeiron.models.Role;
import game.apeiron.models.Theme;
import game.apeiron.repositories.MessageRepository;
import game.apeiron.repositories.ThemeRepository;
import game.apeiron.repositories.UserRepository;

@Controller
public class MessageController {
	@Autowired
	private ThemeRepository themeRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MessageRepository messageRepo;

	@PostMapping("/forum/addMessageToTheme/{id}")
	public String setComment(@PathVariable("id") Integer id, String text, String login) {
		Theme theme = themeRepo.getOne(id);

		Message message = new Message();

		message.setText(text);
		message.setAuthor(userRepo.findByLogin(login).get());
		message.setDate(Calendar.getInstance().getTime());
		message.setTheme(theme);
		messageRepo.saveAndFlush(message);
		return "redirect:/forum/showTheme/{id}";
	}
	
	@GetMapping("/forum/deleteMessage/{login}/{themeid}/{id}")
	private String deleteMessage(@PathVariable("login") String login,  @PathVariable("themeid") Integer themeid, @PathVariable("id") Integer id) {
		if (messageRepo.getOne(id).getAuthor().getLogin().equals(login)
				|| userRepo.findByLogin(login).get().getRoles().contains(Role.ADMIN)) {
			messageRepo.delete(messageRepo.getOne(id));
		}
		return "redirect:/forum/showTheme/{themeid}";
	}
}