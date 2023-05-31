package fr.example.demo.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import fr.example.demo.bll.PersonService;

public class Person{
	
	protected String slug;
	
	@NotBlank
	@Size(min=3)
	protected String firstname;
	
	protected String lastname;
	
	/**
	 * @param firstname
	 * @param lastname
	 */
	public Person(String slug, String firstname, String lastname) {
		super();
		this.slug = slug;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
