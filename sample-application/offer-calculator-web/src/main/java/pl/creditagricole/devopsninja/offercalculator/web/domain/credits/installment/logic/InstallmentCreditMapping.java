package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.logic;

import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.database.InstallmentCreditEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.model.InstallmentCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditDataMapping;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.PersonalDataMapping;

class InstallmentCreditMapping {
	public static InstallmentCreditEntity toEntity(InstallmentCreditApplyRequest source) {
		return InstallmentCreditEntity.builder()
				.creditData(CreditDataMapping.toEntity(source.getCreditData()))
				.personalData(PersonalDataMapping.toEntity(source.getPersonalData()))
				.build();
	}
}
