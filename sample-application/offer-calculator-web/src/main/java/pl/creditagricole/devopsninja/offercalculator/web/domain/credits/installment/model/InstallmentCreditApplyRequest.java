package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.CreditData;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.PersonalData;

@Value
public class InstallmentCreditApplyRequest {
	@NotNull
	@Valid
	private CreditData creditData;
	@NotNull
	@Valid
	private PersonalData personalData;
}
