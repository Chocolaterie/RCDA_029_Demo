package fr.example.demo.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	public String postalCode;

	public String city;
	
	@OneToOne(mappedBy = "adresse")
	public Personne personne;
	
	public Adresse() {
		
	}
	
	/**
	 * @param id
	 * @param postalCode
	 * @param city
	 */
	public Adresse(String postalCode, String city) {
		super();
		this.postalCode = postalCode;
		this.city = city;
	}
}
