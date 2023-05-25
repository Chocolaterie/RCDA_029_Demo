package fr.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.example.demo.bo.Person;

@Controller
public class PersonController {

	@GetMapping("person/{slug}")
	public String person(@PathVariable("slug") String slug, Model model) {
		
		// Créer une personne mocké pour tester
		Person person = new Person(slug, "Sylvain", "DURIF");
		
		// Envoyer dans le model
		model.addAttribute("person", person);
		
		return "person/person";
	}
	
	@PostMapping("person")
	public String personSubmit(@ModelAttribute Person person) {
		
		System.out.println(String.format("Person : %s", person.getFirstname()));
		
		return "redirect:/";
	}
}
