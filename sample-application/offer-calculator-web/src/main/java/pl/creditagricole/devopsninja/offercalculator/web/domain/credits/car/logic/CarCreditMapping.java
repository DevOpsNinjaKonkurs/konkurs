package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.logic;

import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.database.CarCreditEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.model.CarCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditDataMapping;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.PersonalDataMapping;

class CarCreditMapping {
	public static CarCreditEntity toEntity(CarCreditApplyRequest source) {
		return CarCreditEntity.builder()
				.productionYear(source.getProductionYear())
				.creditData(CreditDataMapping.toEntity(source.getCreditData()))
				.personalData(PersonalDataMapping.toEntity(source.getPersonalData()))
				.build();
	}
}
