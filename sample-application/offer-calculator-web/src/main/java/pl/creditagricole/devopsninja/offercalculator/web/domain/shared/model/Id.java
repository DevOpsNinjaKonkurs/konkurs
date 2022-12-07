package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class Id {
	@NotNull
	private Long id;
}
