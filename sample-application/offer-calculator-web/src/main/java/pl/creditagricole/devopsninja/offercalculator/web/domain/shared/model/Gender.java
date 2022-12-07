package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Gender {
	MALE("M"), FEMALE("F");

	private final String shortName;

	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public static Gender fromShort(String shortName){
		return Arrays.stream(values())
				.filter(val -> val.shortName.equals(shortName))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
