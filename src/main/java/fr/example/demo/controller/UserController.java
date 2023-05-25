package fr.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.example.demo.bo.AppUser;

@Controller
@SessionAttributes({"loggedUser"})
public class UserController {

	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("loggedUser", new AppUser("test@gmail.com", "test", "LeFou"));
		
		return "home";
	}
	
	@GetMapping("/show-user")
	public String showLoggedUser(Model model) {
		
		AppUser loggedUser = (AppUser) model.getAttribute("loggedUser");
		System.out.println(loggedUser.getPseudo());
		
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		
		// Vide la session
		sessionStatus.setComplete();
		
		return "redirect:/show-user";
	}
}
