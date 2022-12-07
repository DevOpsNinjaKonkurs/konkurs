package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Gender;

import java.time.LocalDate;

@Getter
@Embeddable
public class PersonalDataEntity {
	private String fullName;
	private String email;
	private String address;
	private LocalDate birthDate;
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public PersonalDataEntity() {
	}

	@Builder
	public PersonalDataEntity(
			@NonNull String fullName,
			@NonNull String email,
			@NonNull String address,
			@NonNull LocalDate birthDate,
			@NonNull Gender gender
	) {
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.birthDate = birthDate;
		this.gender = gender;
	}
}
