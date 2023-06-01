package fr.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import fr.example.demo.bll.CourseService;
import fr.example.demo.bo.Adresse;
import fr.example.demo.bo.Course;
import fr.example.demo.bo.Personne;
import fr.example.demo.dao.jpa.PersonneRepository;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	PersonneRepository personneRepository;
	
	@GetMapping("person-courses-test")
	public String personCourseTest() {
		// Creer une personne
		Personne person = new Personne();
		person.firstname = "Isaac";
		person.lastname = "Toto";
		person.setAdresse(new Adresse("44300", "Nantes"));
		
		// On ajoute les cours
		Course course1 = new Course();
		course1.title = "Spring Java Avancée - Imbuvable";
		
		Course course2 = new Course();
		course2.title = "Comment vendre son projet";
		
		person.courses.add(course1);
		person.courses.add(course2);
		
		// Save
		personneRepository.save(person);
		
		// GET
		Personne personGetted = personneRepository.findById(1L).get();
		
		System.out.println("");
		
		// System.out.println(personGetted);
		
		// System.out.println(personGetted.getAdresse());
		
		System.out.println("Test");
		
		return "home";
	}
	
	@GetMapping("person-test")
	public String personTest() {
		Personne person = new Personne();
		person.firstname = "Isaac";
		person.lastname = "Toto";
		person.setAdresse(new Adresse("44300", "Nantes"));
		
		personneRepository.save(person);
		
		// GET
		Personne personGetted = personneRepository.findById(1L).get();
		
		System.out.println("");
		
		// System.out.println(personGetted);
		
		// System.out.println(personGetted.getAdresse());
		
		System.out.println("Test");
		
		return "home";
	}
	
	
	@GetMapping("course-test")
	public String courseTest() {
		// Insérer une course
		courseService.save(new Course("Course de chevales"));
		
		// Get en base
		Course course1 = courseService.getCourse(1);
		
		// Afficher la course
		System.out.println(course1);
		
		return "home";
	}
}
