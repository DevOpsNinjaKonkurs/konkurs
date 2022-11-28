package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model;

import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class Percent {
	private BigDecimal value;

	private Percent(BigDecimal value) {
		if (value.compareTo(BigDecimal.valueOf(100)) > 0)
			throw new IllegalArgumentException("Value cannot be > 100");
		this.value = value;
	}
}
