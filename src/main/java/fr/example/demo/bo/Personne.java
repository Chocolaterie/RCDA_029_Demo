package fr.example.demo.bo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String lastname;

	public String firstname;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Adresse adresse;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = false)
	@JoinColumn(name="person_id")
	public List<Course> courses;
	
	@ManyToMany()
	public List<Pays> paysVisites;
	
	public Personne() {
		// Attention la liste doit etre vide et non null avant serialization
		courses = new ArrayList<Course>();
	}
	
	/**
	 * Ne va pas en base c'est un utilitaire
	 */
	@Transient
	public String fullname;

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
