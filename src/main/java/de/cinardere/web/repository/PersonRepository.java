package de.cinardere.web.repository;

import org.springframework.data.repository.CrudRepository;

import de.cinardere.web.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

	Person findByName(String name);
	
}
