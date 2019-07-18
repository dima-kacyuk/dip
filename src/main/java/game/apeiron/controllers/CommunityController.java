package game.apeiron.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import game.apeiron.repositories.UserRepository;
import game.apeiron.models.User;

@Controller
public class CommunityController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/community")
	private String getBestPerAllTime(Model model) {
		List<User> getUsers = userRepo.findAll();
		
		List<User> sortedArray = getUsers.stream()
				.sorted(Comparator.comparingInt(User::getRating).reversed())
				.collect(Collectors.toList());
		
		model.addAttribute("users", sortedArray);
		model.addAttribute("contentPage", "community");
		
		return "main";
	}
}
