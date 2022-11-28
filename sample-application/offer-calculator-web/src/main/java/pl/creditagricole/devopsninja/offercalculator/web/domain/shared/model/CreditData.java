package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CreditData {
	@NotNull
	private Long creditAmount;
	@NotNull
	private Integer installmentCount;
}
