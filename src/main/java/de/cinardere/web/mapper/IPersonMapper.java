package de.cinardere.web.mapper;

import de.cinardere.web.domain.Person;
import de.cinardere.web.dto.PersonDto;

public interface IPersonMapper {

	public static Person fromDtoToPOJO(PersonDto dto) {
		final Person pojo = new Person();
			pojo.setName(dto.getName());
			pojo.setAge(dto.getAge());
			pojo.setPassword(dto.getPassword());
		return pojo;
	}

	public static PersonDto fromPOJOToDto(Person pojo) {
		final PersonDto dto = new PersonDto();
			dto.setAge(pojo.getAge());
			dto.setName(pojo.getName());
			dto.setPassword(pojo.getPassword());
			dto.setId(pojo.getId());
		return dto;
	}

}
