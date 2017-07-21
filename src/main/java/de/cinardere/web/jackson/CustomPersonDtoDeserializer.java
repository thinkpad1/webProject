package de.cinardere.web.jackson;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import de.cinardere.web.dto.PersonDto;

public class CustomPersonDtoDeserializer extends StdDeserializer<PersonDto> {

	private static final long serialVersionUID = 1L;

	public CustomPersonDtoDeserializer() {
		this(null);
	}

	protected CustomPersonDtoDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public PersonDto deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		final PersonDto dto = new PersonDto();
		final JsonNode node = parser.getCodec().readTree(parser);

		for (Iterator<String> it = node.fieldNames(); it.hasNext();) {
			final String property = it.next();
			PersonPropertyHelper helper = PersonPropertyHelper.fromValue(property);
			if (helper != null) {
				helper.setValue(dto, node);
			}
		}

		return dto;
	}

	enum PersonPropertyHelper {

		NAME("name") {
			@Override
			public void setValue(PersonDto dto, JsonNode value) {
				dto.setName(value.asText());
			}
		},
		AGE("age") {
			@Override
			public void setValue(PersonDto dto, JsonNode value) {
				dto.setAge(value.asLong());
			}
		},
		PASSWORD("password") {
			@Override
			public void setValue(PersonDto dto, JsonNode value) {
				dto.setPassword(value.asText());
			}
		};

		String property;

		PersonPropertyHelper(String property) {
			this.property = property;
		}

		public static PersonPropertyHelper fromValue(String value) {

			for (final PersonPropertyHelper helper : PersonPropertyHelper.values()) {
				if (helper.property.equals(value)) {
					return helper;
				}
			}

			return null;
		}

		public abstract void setValue(PersonDto dto, JsonNode value);

	}

}
