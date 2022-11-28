package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.logic;

import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.database.CashCreditEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.model.CashCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditDataMapping;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.PersonalDataMapping;

class CashCreditMapping {
	public static CashCreditEntity toEntity(CashCreditApplyRequest source) {
		return CashCreditEntity.builder()
				.creditData(CreditDataMapping.toEntity(source.getCreditData()))
				.personalData(PersonalDataMapping.toEntity(source.getPersonalData()))
				.build();
	}
}
