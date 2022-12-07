package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic;

import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Percent;

import java.math.BigDecimal;

public class CreditParameters {
	public static final Percent CAR_CREDIT_INTEREST_RATE = Percent.of(new BigDecimal("6.1"));
	public static final Percent CASH_CREDIT_INTEREST_RATE = Percent.of(new BigDecimal("9.2"));
	public static final Percent INSTALLMENT_CREDIT_INTEREST_RATE = Percent.of(BigDecimal.ZERO);
}
