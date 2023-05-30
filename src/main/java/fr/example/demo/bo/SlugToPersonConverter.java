package fr.example.demo.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.example.demo.bll.PersonService;

@Component
public class SlugToPersonConverter implements Converter<String, Person> {
	
	@Autowired
	PersonService personService;
	
	@Override
	public Person convert(String slug) {
		return personService.getPersonBySlug(slug);
	}

}
