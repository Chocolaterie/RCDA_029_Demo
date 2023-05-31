package fr.example.demo.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.example.demo.bll.PersonService;
import fr.example.demo.bo.Person;
import fr.example.demo.bo.ServiceResult;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("show-persons")
	public String showAllPerson(Model model) {		
		// 1 : Envoyer les données dans le model pour la vue
		model.addAttribute("persons", personService.getAll());
		
		// 2 : Retourner la vue
		return "person/persons-list";
	}

	@GetMapping("person/{slug}")
	public String person(@PathVariable("slug") String slug, Model model) {
		
		// Récupérer une personne mock
		Person person = personService.getPersonBySlug(slug);
		
		// Envoyer dans le model
		model.addAttribute("person", person);
		
		return "person/person";
	}
	
	/**
	 * Formulaire add person
	 * @param slug
	 * @param model
	 * @return
	 */
	@GetMapping("add-person")
	public String person(Model model) {
		
		// Envoyer dans le model
		model.addAttribute("person", new Person());
		
		return "person/person";
	}
	
	@PostMapping("person")
	public String personSubmit(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		
		// 1 :: Controle de surface
		if(!bindingResult.hasErrors()) {
			
			// 2 :: Controle/Execution métier
			ServiceResult result = personService.addPersonCustom(person);
		
			// 3 :: Tout est ok
			if (result.isValid()) {
				System.out.println("C'est ok");
				
				return "redirect:/";
			}
		}
		return "person/person";
	}
	
	/**
	 * Créer/Modifier une personne
	 * @param person
	 * @return
	 */
	@PostMapping("old-person")
	public String personSubmit(@ModelAttribute("person") Person person) {
		
		System.out.println(String.format("Person : %s", person.getFirstname()));
		
		// Si vide ou null => Creation
		if (null == person.getSlug()) {
			// Générer un slug
			String generateSlug = String.format("slug_%s_%s", person.getFirstname(), person.getLastname());
			person.setSlug(generateSlug);
			
			System.out.println("Creation");
			
			// Ajouter dans la liste de données
			personService.addPerson(person);
		}
		// Edition
		else {
			System.out.println("Edition");
			
			// Modifier dans la liste de données
			personService.editPerson(person);
		}
		
		// Je recois slug
		// est-ce que l'user connecté à le droit de modifier un article avec ce slug
		
		// Métier
		
		
		return "redirect:/";
	}
}
