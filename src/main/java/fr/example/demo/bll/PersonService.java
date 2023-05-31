package fr.example.demo.bll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import fr.example.demo.bo.Person;
import fr.example.demo.bo.ServiceResult;

@Service
public class PersonService {

	List<Person> persons;
	
	PersonService() {
		persons = new ArrayList<Person>();
		/*
		persons = Arrays.asList(new Person[]{
				new Person("isaac", "Isaac", "Chocolatine"),
				new Person("lucas", "Lucas", "PizzaAnanas"),
				new Person("ludovic", "Ludovic", "CrevetteNutella"),
		});
	 	*/
		persons.add(new Person("isaac", "Isaac", "Chocolatine"));
		persons.add(new Person("lucas", "Lucas", "PizzaAnanas"));
		persons.add(new Person("ludovic", "Ludovic", "CrevetteNutella"));
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
	
	/**
	 * Ajouter une personne
	 * @param person
	 */
	public void addPerson(Person person) {
		persons.add(person);
	}

	public void editPerson(Person person) {
		// persons.add(person);
		// Chercher l'index
		int index = 0;
		int indexToEdit = -1;
		for (Person currentPerson : persons) {
			// Si le slug correspond à la personne renseigné
			if (currentPerson.getSlug().equals(person.getSlug())) {
				indexToEdit = index;
			}
			index++;
		}
		
		// Modifier à l'index
		if (indexToEdit > -1) {
			persons.set(indexToEdit, person);
		}
	
	}
	
	public ServiceResult addPersonCustom(Person person) {
		ServiceResult result = new ServiceResult();
		
		// Tester si le prenom est n'est pas existant
		for (Person currentPerson : persons) {
			if (currentPerson.getFirstname().equals(person.getFirstname())) {
				result.addError("Une personne porte déjà ce prénom");
			}
		}
		
		// If no error
		if (result.isValid()) {
			persons.add(person);
		}
		
		return result;
	}
}
