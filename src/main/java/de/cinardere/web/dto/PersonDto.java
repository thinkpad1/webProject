package de.cinardere.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.cinardere.web.jackson.CustomPersonDtoDeserializer;

@JsonDeserialize(using = CustomPersonDtoDeserializer.class)
public class PersonDto {

	private Long id;
	private String name;
	private Long age;
	private String password;

	public PersonDto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PersonDto [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (age != null ? "age=" + age + ", " : "") + (password != null ? "password=" + password : "") + "]";
	}

}
