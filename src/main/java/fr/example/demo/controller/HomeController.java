package fr.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import fr.example.demo.injection.ServicePerson;

@Controller
public class HomeController {

	// Via attribut
	/*
	@Autowired 
	ServicePerson servicePerson;
	*/
	
	// Via le constructeur
	/*
	@Autowired
	HomeController(ServicePerson servicePerson){
		servicePerson.test();
	}
	*/
	
	// Via une fonction
	@Autowired 
	@GetMapping("/detail")
	public String detail(ServicePerson servicePerson) {
		
		servicePerson.test();
		
		return "home";
	}
	
	@GetMapping("/")
	public String home() {
		
		// servicePerson.test();
		
		return "home";
	}
}
