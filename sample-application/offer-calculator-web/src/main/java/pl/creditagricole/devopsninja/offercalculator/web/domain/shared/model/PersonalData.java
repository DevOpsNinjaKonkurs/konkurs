package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class PersonalData {
	@NotBlank
	private String fullName;
	@NotBlank
	private String email;
	@NotBlank
	private String address;
	@NotNull
	private LocalDate birthDate;
	@NotNull
	private Gender gender;
}
