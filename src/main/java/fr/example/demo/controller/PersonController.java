package fr.example.demo.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.example.demo.bo.Person;

@Controller
public class PersonController {

	
	@GetMapping("show-persons")
	public String showAllPerson(Model model) {
		// 1 : Les données en dur
		List<Person> persons = Arrays.asList(new Person[]{
				new Person("isaac", "Isaac", "Chocolatine"),
				new Person("lucas", "Lucas", "PizzaAnanas"),
				new Person("ludovic", "Ludovic", "CrevetteNutella"),
		});
		
		// 2 : Envoyer les données dans le model pour la vue
		model.addAttribute("persons", persons);
		
		// 3 : Retourner la vue
		return "person/persons-list";
	}
	
	@GetMapping("person/{slug}")
	public String person(@PathVariable("slug") String slug, Model model) {
		
		// Créer une personne mocké pour tester
		Person person = new Person(slug, "Sylvain", "DURIF");
		
		// Envoyer dans le model
		model.addAttribute("person", person);
		
		return "person/person";
	}
	
	@PostMapping("person")
	public String personSubmit(@ModelAttribute("formPerson") Person person) {
		
		System.out.println(String.format("Person : %s", person.getFirstname()));
		
		return "redirect:/";
	}
}
