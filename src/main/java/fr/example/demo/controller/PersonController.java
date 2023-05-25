package fr.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.example.demo.bo.Person;

@Controller
public class PersonController {

	@GetMapping("person/{slug}")
	public String person(@PathVariable("slug") String slug, Model model) {
		
		// Créer une personne mocké pour tester
		Person person = new Person(slug, "Sylvain", "DURIF");
		
		return "person/person";
	}
}
