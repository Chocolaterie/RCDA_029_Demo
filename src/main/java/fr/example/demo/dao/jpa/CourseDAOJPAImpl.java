package fr.example.demo.dao.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.example.demo.bo.Course;
import fr.example.demo.dao.CourseDAO;

@Component
@Profile("jpa")
public class CourseDAOJPAImpl implements CourseDAO {

	@Autowired 
	private CourseRepository courseRepository;
	
	@Override
	public Course findById(long id) {
		Optional<Course> course = courseRepository.findById(id);
		
		return course.get();
	}

}
