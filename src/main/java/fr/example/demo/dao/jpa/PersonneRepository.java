package fr.example.demo.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import fr.example.demo.bo.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Long> {

}
