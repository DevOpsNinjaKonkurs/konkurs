package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic;

import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database.CreditDataEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.CreditData;

public class CreditDataMapping {
	public static CreditDataEntity toEntity(CreditData source) {
		return CreditDataEntity.builder()
				.creditAmount(source.getCreditAmount())
				.installmentCount(source.getInstallmentCount())
				.build();
	}
}
