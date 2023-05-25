package fr.example.demo.bll;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import fr.example.demo.bo.Person;

@Service
public class PersonService {

	List<Person> persons;
	
	PersonService() {
		persons = Arrays.asList(new Person[]{
				new Person("isaac", "Isaac", "Chocolatine"),
				new Person("lucas", "Lucas", "PizzaAnanas"),
				new Person("ludovic", "Ludovic", "CrevetteNutella"),
		});
	}
	
	public List<Person> getAll() {
		return persons;
	}
	
	public Person getPersonBySlug(String slug) {
		for (Person person : persons) {
			if (person.getSlug().equals(slug)) {
				return person;
			}
		}
		return null;
	}
}
