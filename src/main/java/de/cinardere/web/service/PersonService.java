package de.cinardere.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.cinardere.web.domain.Person;
import de.cinardere.web.dto.PersonDto;
import de.cinardere.web.mapper.IPersonMapper;
import de.cinardere.web.repository.PersonRepository;

/**
 * Business-Layer
 * 
 * */

@Service
public class PersonService {

	@Autowired
	private PersonRepository repo;
	
	public PersonDto saveNewPerson(PersonDto dto) {
			Person pojo = IPersonMapper.fromDtoToPOJO(dto);
			Person persisted = repo.save(pojo);
		return IPersonMapper.fromPOJOToDto(persisted);
	}

	public PersonDto getPersonByName(String name) {
		Person persisted =  repo.findByName(name);
		return IPersonMapper.fromPOJOToDto(persisted);
	}
	
	
	
}
