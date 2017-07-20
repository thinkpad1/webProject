package de.cinardere.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.cinardere.web.dto.PersonDto;
import de.cinardere.web.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.GET, value = "/person/{name}")
	public ResponseEntity<PersonDto> getPerson(@PathVariable("name") String name) {
		return new ResponseEntity<PersonDto>(personService.getPersonByName(name), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/person")
	public ResponseEntity<PersonDto> saveNewPerson(@RequestBody PersonDto dto) {
		return new ResponseEntity<PersonDto>(personService.saveNewPerson(dto), HttpStatus.OK);
	}

}
