package de.cinardere.web.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import de.cinardere.web.dto.PersonDto;

public class CustomPersonDtoDeserializer extends StdDeserializer<PersonDto>{

	public CustomPersonDtoDeserializer() {
		this(null);
		
	}
	protected CustomPersonDtoDeserializer(Class<?> vc) {
		super(vc);
	}
	private static final long serialVersionUID = 1L;

	@Override
	public PersonDto deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		
		PersonDto dto = new PersonDto();
		JsonNode node = parser.getCodec().readTree(parser);
		
		String name = node.get("name").asText();
		Long age = node.get("age").asLong();
		String pw = node.get("password").asText();
			dto.setAge(age);
			dto.setName(name);
			dto.setPassword(pw);
		return dto;
	}

}
