package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.CreditData;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.PersonalData;

@Value
public class CashCreditApplyRequest {
	@NotNull
	@Valid
	private CreditData creditData;
	@NotNull
	@Valid
	private PersonalData personalData;
}
