package fr.example.demo.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import fr.example.demo.bo.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
