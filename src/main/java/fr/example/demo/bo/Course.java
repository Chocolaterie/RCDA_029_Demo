package fr.example.demo.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	public String title;
	
	/**
	 * Uniquemenbt pour le rendre bidirectionnelle
	 */
	@ManyToOne()
	public Personne person;
	
	public Course() {
		
	}

	public Course(String title) {
		this.id = -1L;
		this.title = title;
	}
	
	public Course(long id, String title) {
		this.id = id;
		this.title = title;
	}
	

}
