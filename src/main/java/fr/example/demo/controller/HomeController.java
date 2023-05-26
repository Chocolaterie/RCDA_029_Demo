package fr.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.example.demo.injection.ServicePerson;

@Controller
@SessionAttributes({"loggedUser"})
public class HomeController {

	// Via une fonction
	@Autowired
	@GetMapping("/detail")
	public String detail(ServicePerson servicePerson) {
		
		servicePerson.test();
		
		return "home";
	}
	
	@GetMapping("test-redirect")
	public String testRedirect() {
		return "redirect:/default-article";
	}
	
	@GetMapping("default-article")
	public String defaultArticle(Model model) {
		// Creer une donnée
		String articleName = "Pizza Ananas c'est la vie";
		
		// Envoyer la donnée dans le model
		model.addAttribute("articleName", articleName);
		
		// Retourner la page
		return "article";
	}
	
	@GetMapping("article/{id}")
	public String article(@PathVariable("id") int id ) {
		
		System.out.println(String.format("Voici l'id transféré depuis l'url %d", id));
		
		// Affiche la page home
		return "home";
	}
	
	@GetMapping("catalogue")
	public String catalogue(@RequestParam("type") String type) {
		
		System.out.println(String.format("Voici le type %s", type));
		
		// Affiche la page home
		return "home";
	}
	
	@GetMapping("/")
	public String home() {
		
		// servicePerson.test();
		
		return "home";
	}
}
