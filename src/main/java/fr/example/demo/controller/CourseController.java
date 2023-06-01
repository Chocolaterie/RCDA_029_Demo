package fr.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import fr.example.demo.bll.CourseService;
import fr.example.demo.bo.Course;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;
	
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
