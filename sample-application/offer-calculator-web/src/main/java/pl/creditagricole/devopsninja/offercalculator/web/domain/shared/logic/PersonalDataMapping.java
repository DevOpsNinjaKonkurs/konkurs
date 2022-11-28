package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic;

import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database.PersonalDataEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.PersonalData;

public class PersonalDataMapping {
	public static PersonalDataEntity toEntity(PersonalData source) {
		return PersonalDataEntity.builder()
				.address(source.getAddress())
				.email(source.getEmail())
				.gender(source.getGender())
				.fullName(source.getFullName())
				.birthDate(source.getBirthDate())
				.build();
	}
}
