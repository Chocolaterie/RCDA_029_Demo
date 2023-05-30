package fr.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.example.demo.bll.PersonService;
import fr.example.demo.bo.Classroom;

@Controller
public class ClassroomController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/classroom")
	public String classroomForm(Model model) {
		
		// Le formulaire
		model.addAttribute("classroom", new Classroom());
		
		// Envoyer la liste des personnes des selectionnable
		model.addAttribute("personOptions", personService.getAll());
		
		return "person/create-classroom";
	}
	
	@PostMapping("/create-classroom")
	public String postClassroomForm(@ModelAttribute("classroom") Classroom classroom, Model model) {
		
		return "person/create-classroom";
	}
	
	
}
