package fr.example.demo.bll;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.example.demo.bo.Course;
import fr.example.demo.dao.CourseDAO;
import fr.example.demo.dao.jpa.CourseRepository;

@Service
public class CourseService {

	@Autowired 
	private CourseRepository courseRepository;
	
	public void save(Course course) {
		courseRepository.save(course);
	}
	
	public Course getCourse(long id) {
		Optional<Course> course = courseRepository.findById(id);
		
		return course.get();
	}
	
}
